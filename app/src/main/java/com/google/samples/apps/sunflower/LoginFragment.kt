/*
 * Copyright 2018 Google LLC
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

package com.google.samples.apps.sunflower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.samples.apps.sunflower.databinding.FragmentLoginBinding
import com.talobin.robinhood.api.NetworkClient
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    private val networkClient = NetworkClient

    //Example of dependency injection
/*    @Inject
    lateinit var service: RobinhoodService*/
    private var currentSearchQuery = "AAAA"

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {

            Log.d("HAI", "pass: " + binding.password)
            Log.d("HAI", "user: " + binding.username)
            networkClient.startLogin(binding.username.toString(), binding.password.toString())
        }

        binding.verifyButton.setOnClickListener {
            Log.d("HAI", "mfa: " + binding.mfa)
            networkClient.verifyMFACode(binding.mfa.toString())
        }

        binding.accountButton.setOnClickListener {
           // networkClient.getPhoenixAccount()
            fourLetterWords.concatMap { i -> Observable.just(i).delay(100, TimeUnit.MICROSECONDS) }
                    .map { query ->
                        // Log.d("HAI", "Searching for " + query)
                        networkClient.searchProper(query)?.subscribeOn(Schedulers.io())?.map { resultList ->
                            if (resultList != null) {
                                for (eachResult in resultList) {
                                    symbolsSet.add(eachResult.symbol)
                                    Log.d("HAI", "Search result " + eachResult.symbol + " Size: " + symbolsSet.size)
                                }
                            } else {
                                Log.d("HAI", "Empty result " + resultList)
                            }
                        }?.subscribe()
                    }.doOnComplete {
                        Log.d("HAI", "Final Set 2" + symbolsSet)

                    }.subscribeOn(Schedulers.io())?.subscribe()
        }

        binding.testButton.setOnClickListener {
            // networkClient.removeSymbolFromList("d3702af7-60ba-418c-982f-51e2a931f74a","e39ed23a-7bd1-4587-b060-71988d9ef483")
            // 4b91da2c-2878-4c82-80ec-d6a0d2cb4a28
            //e39ed23a-7bd1-4587-b060-71988d9ef483
            //  networkClient.getPriceBookByID("e39ed23a-7bd1-4587-b060-71988d9ef483")
            /*   networkClient.searchProper("A")?.map { result ->
                   Log.d("HAI", "Search result for A" + result?.get(0)?.symbol)
               }?.subscribe()
   */
            executeAllSearches()
        }

        networkClient.init(requireContext())

        return binding.root
    }


    private fun executeAllSearches() {

        allSearchQueries.concatMap { i -> Observable.just(i).delay(100, TimeUnit.MICROSECONDS) }
                .map { query ->
                    // Log.d("HAI", "Searching for " + query)
                      networkClient.searchProper(query)?.subscribeOn(Schedulers.io())?.map { resultList ->
                          if (resultList != null) {
                              for (eachResult in resultList) {
                                  symbolsSet.add(eachResult.symbol)
                                  Log.d("HAI", "Search result " + eachResult.symbol + " Size: " + symbolsSet.size)
                              }
                          } else {
                                Log.d("HAI", "Empty result " + resultList)
                          }
                      }?.subscribe()
                }.doOnDispose {
                    Log.d("HAI", "Final Set 1" + symbolsSet)
                }.subscribeOn(Schedulers.io())?.subscribe()

        /* networkClient.searchProper("A")?.map { result ->
             Log.d("HAI", "Search result for A" + result)
         }?.subscribe()*/
    }

    var symbolsSet: MutableSet<String> = HashSet()

    val characterSpitter1 = Observable.merge(
            Observable.just('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'),
            Observable.just('K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'),
            Observable.just('U', 'V', 'W', 'X', 'Y', 'Z'))
    val characterSpitter2 = Observable.merge(
            Observable.just('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'),
            Observable.just('K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'),
            Observable.just('U', 'V', 'W', 'X', 'Y', 'Z'))
    val characterSpitter3 = Observable.merge(
            Observable.just('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'),
            Observable.just('K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'),
            Observable.just('U', 'V', 'W', 'X', 'Y', 'Z'))
    val characterSpitter4 = Observable.merge(
            Observable.just('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'),
            Observable.just('K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'),
            Observable.just('U', 'V', 'W', 'X', 'Y', 'Z'))

    val fourLetterWords :Observable<String> = characterSpitter1.flatMap { firstChar ->
        fourLetterArray[0] = firstChar
        characterSpitter2.map { secondChar ->
            fourLetterArray[1] = secondChar
        }
    }.flatMap { firstAndSecond ->
        characterSpitter3.map { thirdChar ->
            fourLetterArray[2] = thirdChar
        }
    }.flatMap { firstSecondAndThird ->
        characterSpitter4.map { fourth ->
            fourLetterArray[3] = fourth
        }
    }.map{
        eachCharacter ->
        String(fourLetterArray)
    }

    val threeLetterWords :Observable<String> = characterSpitter1.flatMap { firstChar ->
        threeLetterArray[0] = firstChar
        characterSpitter2.map { secondChar ->
            threeLetterArray[1] = secondChar
        }
    }.flatMap { firstAndSecond ->
        characterSpitter3.map { thirdChar ->
            threeLetterArray[2] = thirdChar
        }
    }.map{
        eachCharacter ->
        String(threeLetterArray)
    }

    val twoLetterWords :Observable<String> = characterSpitter1.flatMap { firstChar ->
        twoLetterArray[0] =  firstChar
        characterSpitter2.map { secondChar ->
            twoLetterArray[1] =  secondChar
        }
    }.map{
        eachCharacter ->
        String(twoLetterArray)
    }

    val oneLetterWords :Observable<String> = characterSpitter1.map { firstChar ->
        oneLetterArray[0] =  firstChar
    }.map{
        eachCharacter ->
        String(oneLetterArray)
    }


    val allSearchQueries = Observable.merge(oneLetterWords, twoLetterWords, threeLetterWords)

    val fourLetterArray: CharArray = CharArray(4) { _ -> 'A' }
    val threeLetterArray: CharArray = CharArray(3) { _ -> 'A' }
    val twoLetterArray: CharArray = CharArray(2) { _ -> 'A' }
    val oneLetterArray: CharArray = CharArray(1) { _ -> 'A' }

}
