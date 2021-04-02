/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.talobin.robinhood

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.talobin.robinhood.api.NetworkClient
import com.talobin.robinhood.util.RandomQueryGenerator
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object RHSDK {
    private val networkClient = NetworkClient
    private val queryGenerator = RandomQueryGenerator
    private val symbolSet: MutableSet<String> = HashSet()

    private val symbolsSubject = PublishSubject.create<String>()
    private val symbolsObservable: Observable<String> = symbolsSubject.flatMap { it -> Observable.just(it) }

    fun getNetworkClient(): NetworkClient {
        return networkClient
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllSymbolsFromCache(context: Context?): List<String> {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(
                    InputStreamReader(context?.getAssets()?.open("symbols.json")));

            val mLine = reader?.readLines()
            Log.d("HAI", "Found symbols" + mLine.size)
            return mLine

        } catch (e: IOException) {
            Log.d("HAI", "Crapola " + e)
            //log the exception
        } finally {
            try {
                reader?.close()
            } catch (e: IOException) {
                Log.d("HAI", "Crapola " + e)
            }
        }
        return ArrayList()


    }


    fun getAllSymbolsFromAPI(): @NonNull Observable<String> {
        makeAPICallForSymbol().subscribe()
        return symbolsObservable
    }

    private fun makeAPICallForSymbol(): @NonNull Observable<String> {
        val nextQuery = queryGenerator.getNextQuery()
        if (nextQuery.isNotBlank()) {
            val temp = networkClient.searchProper(nextQuery)
            if (temp != null) {
                return temp.subscribeOn(Schedulers.io()).flattenAsObservable { eachResultList ->
                    eachResultList
                }.filter { eachItem ->
                    !symbolSet.contains(eachItem.symbol)
                }.map { eachItem ->
                    eachItem.symbol
                }.doOnNext { eachSymbol ->
                    symbolsSubject.onNext(eachSymbol)
                    symbolSet.add(eachSymbol)
                }.doOnComplete {
                    getAllSymbolsFromAPI().subscribe()
                }
            } else {
                symbolsSubject.onError(Throwable("Network error!"))
                return Observable.just("")
            }
        } else {
            Log.d("HAI", "We are done here " + symbolSet.size)
            symbolsSubject.onComplete()
            return Observable.just(null)
        }
    }
    /*   map { resultList ->
                     if (resultList != null) {
                         for (eachResult in resultList) {
                             val symbol = eachResult.symbol
                             if (!symbolSet.contains(symbol)) {
                                 symbolSet.add(symbol)
                                 Log.d("HAI", symbol + " | " + symbolSet.size)
                             }
                         }
                     } else {
                         Log.d("HAI", "Empty result " + resultList)
                     }
                 }?.*/
}