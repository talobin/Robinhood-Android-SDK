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

package com.talobin.robinhood.api

import android.content.Context
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder
import androidx.datastore.rxjava3.RxDataStore
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
object DataStoreClient {
    lateinit var dataStore: RxDataStore<Preferences>
    val CHALLENGE_ID = stringPreferencesKey("challengeID")
    val ACCESS_TOKEN = stringPreferencesKey("accessToken")
    val ACCOUNT_NUMBER = stringPreferencesKey("accountNumber")

    /**
     * @param context the coroutine code.
     * @return something here
     */
    fun init(context: Context) {
        dataStore = RxPreferenceDataStoreBuilder(context, "session").build()
    }


    fun loadChallengeID(): @NonNull Single<String?> {
        return dataStore.data().map { currentPreferences ->
            if (!currentPreferences[CHALLENGE_ID].isNullOrBlank()) {
                currentPreferences[CHALLENGE_ID]
            } else {
                ""
            }
        }.first("").subscribeOn(Schedulers.io())
    }

    fun saveChallengeID(challengeID: String): @NonNull Single<Preferences> {
        return dataStore.updateDataAsync(
        ) { prefsIn ->
            val mutablePreferences: MutablePreferences = prefsIn.toMutablePreferences()
            mutablePreferences[CHALLENGE_ID] = challengeID
            Single.just(mutablePreferences)
        }.subscribeOn(Schedulers.io())
    }

    fun saveAccessToken(accessToken: String): @NonNull Single<Preferences> {
        return dataStore.updateDataAsync(
        ) { prefsIn ->
            val mutablePreferences: MutablePreferences = prefsIn.toMutablePreferences()
            mutablePreferences[ACCESS_TOKEN] = accessToken
            Single.just(mutablePreferences)
        }.subscribeOn(Schedulers.io())
    }

    fun loadAccessToken(): @NonNull Single<String?> {
        return dataStore.data().map { currentPreferences ->
            if (!currentPreferences[ACCESS_TOKEN].isNullOrBlank()) {
                currentPreferences[ACCESS_TOKEN]
            } else {
                ""
            }
        }.first("").subscribeOn(Schedulers.io())
    }

    fun saveAccountNumber(accountNumber: String): @NonNull Single<Preferences> {
        return dataStore.updateDataAsync(
        ) { prefsIn ->
            val mutablePreferences: MutablePreferences = prefsIn.toMutablePreferences()
            mutablePreferences[ACCOUNT_NUMBER] = accountNumber
            Single.just(mutablePreferences)
        }.subscribeOn(Schedulers.io())
    }

    fun loadAccountNumber(): @NonNull Single<String?> {
        return dataStore.data().map { currentPreferences ->
            if (!currentPreferences[ACCOUNT_NUMBER].isNullOrBlank()) {
                currentPreferences[ACCOUNT_NUMBER]
            } else {
                ""
            }
        }.first("").subscribeOn(Schedulers.io())
    }
}