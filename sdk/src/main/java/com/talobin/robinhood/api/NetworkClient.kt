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
import android.util.Log
import com.google.gson.Gson
import com.talobin.robinhood.data.account.*
import com.talobin.robinhood.data.auth.*
import com.talobin.robinhood.data.stock.SearchResult
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import retrofit2.HttpException
import java.util.*


@ExperimentalCoroutinesApi
object NetworkClient {

    private val service = RobinhoodService.create()
    private val dataStore = DataStoreClient

    private var oAuthPayload: LoginRequestBody? = null

    fun init(context: Context) {
        dataStore.init(context)
    }

    //region AUTH APIs
    fun startLogin(username: String, password: String) {
        oAuthPayload = LoginRequestBody(username, password, UUID.randomUUID().toString())
        service.postOAuthRequestSMS(oAuthPayload).subscribeOn(Schedulers.io())
                .subscribe({ response ->
                    Log.d("HAI", "loginRequestSMSCode' " + response)
                },
                        { error ->
                            if (error is HttpException) {
                                val errorBody: String = error.response()?.errorBody()!!.string()
                                // use GSon to parse json to your Error handling model class
                                val errorResponse: SMSRequestResponse =
                                        Gson().fromJson(errorBody, SMSRequestResponse::class.java)
                                val challengeID = errorResponse.challenge?.id.toString()

                                dataStore.saveChallengeID(challengeID).subscribe()

                                Log.d("HAI", "Good Response loginRequestSMSCode' " + errorResponse)
                            } else {
                                Log.e("HAI", "Unkown Error loginRequestSMSCode' " + error)
                            }

                        }
                )
    }


    fun verifyMFACode(mfa: String) {
        dataStore.loadChallengeID().subscribe { currentChallengeID ->
            if (!currentChallengeID.isNullOrBlank()) {
                Log.d("HAI", "challengeID " + currentChallengeID)
                val payload = MFAVerifyRequest(mfa)
                service.postOAuthVerifySMS(payload, currentChallengeID).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "verifyMFACode " + response)
                            val validMFA = response.status.equals(VALIDATED) && !response.id.isNullOrBlank()
                            if (validMFA) {
                                getAccessToken(response.id)
                            } else {
                                Log.e("HAI", "MFA is not verified ")
                            }

                        }, { error ->
                            Log.e("HAI", "error verifyMFACode " + error)
                        })
            } else {
                Log.e("HAI", "No challenge found")
            }
        }
    }

    private fun getAccessToken(challengeResponseID: String) {
        if (oAuthPayload != null) {
            service.postOAuthGetAccessToken(oAuthPayload, challengeResponseID).subscribeOn(Schedulers.io())
                    .subscribe({ response ->
                        Log.d("HAI", "loginGetAccessToken " + response)
                        dataStore.saveAccessToken(response.getAccessString()).subscribe()
                    },
                            { error ->
                                Log.e("HAI", "error loginGetAccessToken " + error)
                            }
                    )
        } else {
            Log.e("HAI", "getAccessToken oAuthPayload is null")
        }
    }
    //endregion


    //region Profile APIs
    fun getBasicInfo() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getBasicInfo(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getBasicInfo " + response)
                        },
                                { error ->
                                    Log.e("HAI", "error getBasicInfo " + error)
                                }
                        )
            } else {
                Log.e("HAI", "error getBasicInfo accessToken is empty")
            }
        }
    }

    fun getInvestmentProfile() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getInvestmentProfile(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getInvestmentProfile " + response)
                        },
                                { error ->
                                    Log.e("HAI", "error getInvestmentProfile " + error)
                                }
                        )
            } else {
                Log.e("HAI", "error getInvestmentProfile accessToken is empty")
            }
        }
    }

    fun getPortfolios() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getPortfolios(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getPortfolios " + response)
                        },
                                { error ->
                                    Log.e("HAI", "error getPortfolios " + error)
                                }
                        )
            } else {
                Log.e("HAI", "error getPortfolios accessToken is empty")
            }
        }
    }

    fun getAdditionalInfo() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getAdditionalInfo(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getAdditionalInfo " + response)
                        },
                                { error ->
                                    Log.e("HAI", "error getAdditionalInfo " + error)
                                }
                        )
            } else {
                Log.e("HAI", "error getAdditionalInfo accessToken is empty")
            }
        }
    }

    fun getUser() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getUser(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getAdditionalInfo " + response)
                        },
                                { error ->
                                    Log.e("HAI", "error getAdditionalInfo " + error)
                                }
                        )
            } else {
                Log.e("HAI", "error getAdditionalInfo accessToken is empty")
            }
        }
    }

    fun getAccounts() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getAccounts(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getAccounts " + response)
                        },
                                { error ->
                                    Log.e("HAI", "error getAccounts " + error)
                                }
                        )
            } else {
                Log.e("HAI", "error getAccounts accessToken is empty")
            }
        }
    }

    //endregion


    //region Account APIs
    fun getPhoenixAccount() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                RobinhoodService.switchToPhoenixHost()
                service.getPhoenixAccount(accessToken).subscribeOn(Schedulers.io())
                        .doOnTerminate { RobinhoodService.switchToNormalHost() }
                        .subscribe({ response ->
                            Log.d("HAI", "getPhoenixAccount " + response)
                            dataStore.saveAccountNumber(response.equities.apex_account_number).subscribe()
                        }, { error ->
                            Log.e("HAI", "error getPhoenixAccount " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getPhoenixAccount accessToken is empty")
            }
        }
    }

    fun getHistoricalPortfolio(interval: HistorialcalPortfolioRequest.Interval,
                               span: HistorialcalPortfolioRequest.Span, bounds: HistorialcalPortfolioRequest.Bounds) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                dataStore.loadAccountNumber().subscribe { accountNumber ->
                    if (!accountNumber.isNullOrBlank()) {
                        //Log.d("HAI", "accountNumber " + accountNumber)
                        service.getHistoricalPortfolio(accessToken, accountNumber, interval.value, span.value, bounds.value)
                                .subscribeOn(Schedulers.io())
                                .subscribe({ response ->
                                    Log.d("HAI", "getHistoricalPortfolio " + response)
                                }, { error ->
                                    Log.e("HAI", "error getHistoricalPortfolio " + error)
                                }
                                )
                    } else {
                        Log.e("HAI", "error getHistoricalPortfolio accountNumber is empty")
                    }
                }
            } else {
                Log.e("HAI", "error getHistoricalPortfolio accessToken is empty")
            }
        }
    }

    fun getPositions(nonZero: Boolean) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                Log.d("HAI", "nonZero " + nonZero.toString())
                service.getPositions(accessToken, nonZero.toString()).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getPositions " + response)
                        }, { error ->
                            Log.e("HAI", "error getPositions " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getPositions accessToken is empty")
            }
        }
    }

    fun getDividends() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getDividends(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getDividends " + response)
                        }, { error ->
                            Log.e("HAI", "error getDividends " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getDividends accessToken is empty")
            }
        }
    }

    fun getBankAccounts() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getBankAccounts(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getBankAccounts " + response)
                        }, { error ->
                            Log.e("HAI", "error getBankAccounts " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getBankAccounts accessToken is empty")
            }
        }
    }

    fun getBankAccountInfo(bankID: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getBankAccountInfo(accessToken, bankID).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getBankAccountInfo " + response)
                        }, { error ->
                            Log.e("HAI", "error getBankAccountInfo " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getBankAccountInfo accessToken is empty")
            }
        }
    }

    fun getBankTransfers(direction: Direction) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getBankTransfers(accessToken, direction.value).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getBankTransfers " + response)
                        }, { error ->
                            Log.e("HAI", "error getBankTransfers " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getBankTransfers accessToken is empty")
            }
        }
    }

    fun getCardTransactions(type: TransactionType) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                RobinhoodService.switchToMinervaHost()
                service.getCardTransactions(accessToken, type.value).subscribeOn(Schedulers.io())
                        .doOnTerminate { RobinhoodService.switchToNormalHost() }
                        .subscribe({ response ->
                            Log.d("HAI", "getCardTransactions " + response)
                        }, { error ->
                            Log.e("HAI", "error getCardTransactions " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getCardTransactions accessToken is empty")
            }
        }
    }

    fun getSubscriptionFees() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getSubscriptionFees(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getSubscriptionFees " + response)
                        }, { error ->
                            Log.e("HAI", "error getSubscriptionFees " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getSubscriptionFees accessToken is empty")
            }
        }
    }

    fun getReferrals() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getReferrals(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getReferrals " + response)
                        }, { error ->
                            Log.e("HAI", "error getReferrals " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getReferrals accessToken is empty")
            }
        }
    }

    fun getDocuments() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getDocuments(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getDocuments " + response)
                        }, { error ->
                            Log.e("HAI", "error getDocuments " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getDocuments accessToken is empty")
            }
        }
    }

    fun getLists() {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getLists(accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getLists " + response)
                        }, { error ->
                            Log.e("HAI", "error getLists " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getLists accessToken is empty")
            }
        }
    }

    fun getListInfo(listID: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getListInfo(accessToken, listID).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getListInfo " + response)
                        }, { error ->
                            Log.e("HAI", "error getListInfo " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getListInfo accessToken is empty")
            }
        }
    }

    fun addSymbolToList(listID: String, symbolID: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                val postObject = ObjectUnit(symbolID, OBJECT_TYPE_INSTRUMENT, OPERATION_CREATE)
                val listPostObject: List<ObjectUnit> = listOf(postObject)
                val jsonString = "{" + Gson().toJson(listID) + ":" + Gson().toJson(listPostObject) + "}"
                /*
                val jsonParams: MutableMap<String?, Any?> = ArrayMap()
                jsonParams.put(listID, jsonArray)
                val body3: MutableMap<String, List<ObjectUnit>> = HashMap()
                body3.put(listID,listPostObject)
                Log.d("HAI", " 1 item " + Gson().toJson(postObject))
                  og.d("HAI", " list " + Gson().toJson(listPostObject))
                   Log.d("HAI", " map " + Gson().toJson(body3))
                   Log.d("HAI", " after " + JSONObject(body3 as Map<*, *>).toString())
                 val mapType = object : TypeToken<Map<String, List<ObjectUnit>>>() {}.type
                Log.d("HAI", " final " + jsonString)
                   val body2: Map<String, List<ObjectUnit>> = Gson().
                   fromJson("{'d3702af7-60ba-418c-982f-51e2a931f74a':[{'object_type':'instrument','object_id':'e39ed23a-7bd1-4587-b060-71988d9ef483','operation':'create'},{}]}", mapType)*/


                val body: RequestBody = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), jsonString)

                service.postAddSymbolToList(body, accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "addSymbolToList " + response)
                        }, { error ->
                            if (error is HttpException) {

                                Log.e("HAI", "Known Error addSymbolToList' " + error.response()?.errorBody()?.string())
                            } else {
                                Log.e("HAI", "Unkown Error addSymbolToList' " + error)
                            }
                        }
                        )

            } else {
                Log.e("HAI", "error addSymbolToList accessToken is empty")
            }
        }
    }

    fun removeSymbolFromList(listID: String, symbolID: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                val postObject = ObjectUnit(symbolID, OBJECT_TYPE_INSTRUMENT, OPERATION_DELETE)
                val listPostObject: List<ObjectUnit> = listOf(postObject)
                val jsonString = "{" + Gson().toJson(listID) + ":" + Gson().toJson(listPostObject) + "}"
                val body: RequestBody = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), jsonString)
                service.postAddSymbolToList(body, accessToken).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "addSymbolToList " + response)
                        }, { error ->
                            if (error is HttpException) {

                                Log.e("HAI", "Known Error addSymbolToList' " + error.response()?.errorBody()?.string())
                            } else {
                                Log.e("HAI", "Unkown Error addSymbolToList' " + error)
                            }
                        }
                        )

            } else {
                Log.e("HAI", "error addSymbolToList accessToken is empty")
            }
        }
    }

    //endregion

    //region Stocks APIs
    fun getQuotesBySymbol(symbol: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getQuotesBySymbol(accessToken, symbol).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getQuotes single " + response)
                        }, { error ->
                            Log.e("HAI", "error getQuotes single" + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getQuotes single accessToken is empty")
            }
        }
    }

    fun getQuotesBySymbols(symbols: List<String>) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getQuotesBySymbol(accessToken, symbols.joinToString(",")).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getQuotes list " + response)
                        }, { error ->
                            Log.e("HAI", "error getQuotes list " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getQuotes list accessToken is empty")
            }
        }
    }

    fun getQuotesByID(symbolID: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getQuotesByID(accessToken, symbolID).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getQuotes list " + response)
                        }, { error ->
                            Log.e("HAI", "error getQuotes list " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getQuotes list accessToken is empty")
            }
        }
    }

    fun getFundamentals(symbol: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getFundamentals(accessToken, symbol).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getFundamental single " + response)
                        }, { error ->
                            Log.e("HAI", "error getFundamental single " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getQuote single accessToken is empty")
            }
        }
    }

    fun getFundamentals(symbols: List<String>) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getFundamentals(accessToken, symbols.joinToString(",")).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getFundamentals list " + response)
                        }, { error ->
                            Log.e("HAI", "error getFundamentals list " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getFundamentals list accessToken is empty")
            }
        }
    }

    fun getInstruments(symbols: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getInstruments(accessToken, symbols).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getInstruments single " + response)
                        }, { error ->
                            Log.e("HAI", "error getInstruments single " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getInstruments single accessToken is empty")
            }
        }
    }

    fun getInstruments(symbols: List<String>) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getInstruments(accessToken, symbols.joinToString(",")).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getInstruments list " + response)
                        }, { error ->
                            Log.e("HAI", "error getInstruments list " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getInstruments list accessToken is empty")
            }
        }
    }

    fun getRatings(symbols: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getRatings(accessToken, symbols).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getRatings single " + response)
                        }, { error ->
                            Log.e("HAI", "error getRatings single " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getRatings single accessToken is empty")
            }
        }
    }

    fun getRatings(symbols: List<String>) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getRatings(accessToken, symbols.joinToString(",")).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getRatings list " + response)
                        }, { error ->
                            Log.e("HAI", "error getRatings list " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getRatings list accessToken is empty")
            }
        }
    }

    fun getEvents(instrumentID: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getEvents(accessToken, instrumentID).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getEvents " + response)
                        }, { error ->
                            Log.e("HAI", "error getEvents " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getEvents accessToken is empty")
            }
        }
    }

    fun getEarnings(symbols: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getEarnings(accessToken, symbols).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getEarnings  " + response)
                        }, { error ->
                            Log.e("HAI", "error getEarnings  " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getEarnings  accessToken is empty")
            }
        }
    }

    fun getNews(symbols: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getNews(accessToken, symbols).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getNews  " + response)
                        }, { error ->
                            Log.e("HAI", "error getNews  " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getNews  accessToken is empty")
            }
        }
    }

    fun getSplits(symbolID: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getSplits(accessToken, symbolID).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getSplits  " + response)
                        }, { error ->
                            Log.e("HAI", "error getSplits  " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getSplits  accessToken is empty")
            }
        }
    }

    fun search(query: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getInstrumentData(accessToken, query).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "search  " + response)
                        }, { error ->
                            Log.e("HAI", "error search  " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error search  accessToken is empty")
            }
        }
    }

    fun getPriceBookByID(symbolID: String) {
        dataStore.loadAccessToken().subscribe { accessToken ->
            if (!accessToken.isNullOrBlank()) {
                Log.d("HAI", "accessToken " + accessToken)
                service.getPriceBookByID(accessToken, symbolID).subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d("HAI", "getPriceBookByID " + response)
                        }, { error ->
                            Log.e("HAI", "error getPriceBookByID " + error)
                        }
                        )
            } else {
                Log.e("HAI", "error getPriceBookByID accessToken is empty")
            }
        }
    }

    //endregion

    fun searchProper(query: String): @NonNull Single<List<SearchResult>?>? {
        /*dataStore.loadAccessToken().subscribe { accessToken ->
           if (!accessToken.isNullOrBlank()) {

               return service.getInstrumentData(accessToken, query).subscribeOn(Schedulers.io())
                       .map { response -> response.searchResults }
           } else {

           }
       }
       */
        return dataStore.loadAccessToken().flatMap { accessToken ->
            if(accessToken!=null){
           //     Log.d("HAI", "accessToken " + accessToken)
                service.getInstrumentData(accessToken, query).subscribeOn(Schedulers.io())
                        .map { response -> response.searchResults }
            }else{
                Log.e("HAI", "error search  accessToken is empty")
                Single.just(null)
            }
        }
    }

}