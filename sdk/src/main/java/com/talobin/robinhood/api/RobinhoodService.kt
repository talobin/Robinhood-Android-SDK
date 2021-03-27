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

import com.talobin.robinhood.data.GetUserResponse
import com.talobin.robinhood.data.account.*
import com.talobin.robinhood.data.auth.*
import com.talobin.robinhood.data.profile.GetAccountsResponse
import com.talobin.robinhood.data.profile.GetAdditionalInfoResponse
import com.talobin.robinhood.data.profile.GetBasicInfoResponse
import com.talobin.robinhood.data.profile.GetInvestmentProfileResponse
import com.talobin.robinhood.data.stock.*
import com.talobin.robinhood.util.HostSelectionInterceptor
import io.reactivex.rxjava3.core.Single
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import okio.IOException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Used to connect to the Unsplash API to fetch photos
 */
interface RobinhoodService {


    companion object {
        private const val NORMAL_BASE_URL = "https://api.robinhood.com/"
        private const val PHOENIX_HOST = "phoenix.robinhood.com"
        private const val NORMAL_HOST = "api.robinhood.com"
        private const val MINERVA_HOST = "minerva.robinhood.com"


        private var interceptor: Interceptor = object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val newRequest: Request = chain.request().newBuilder()
                        .addHeader("Accept", "*/*")
                        .addHeader("Accept-Encoding", "gzip,deflate,br")
                        .addHeader("Accept-Language", "en-US,en;q=1")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                        .addHeader("X-Robinhood-API-Version", "1.315.0")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("User-Agent", "")
                        .build()
                return chain.proceed(newRequest)
            }
        }

        private val hostChangeInterceptor = HostSelectionInterceptor()

        fun switchToMinervaHost() {
            hostChangeInterceptor.setHost(MINERVA_HOST)
        }

        fun switchToPhoenixHost() {
            hostChangeInterceptor.setHost(PHOENIX_HOST)
        }

        fun switchToNormalHost() {
            hostChangeInterceptor.setHost(NORMAL_HOST)
        }

        fun create(): RobinhoodService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .addInterceptor(hostChangeInterceptor)
                    .build()

            return Retrofit.Builder()
                    .baseUrl(NORMAL_BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()
                    .create(RobinhoodService::class.java)
        }
    }


    //region AUTH APIs
    @POST("oauth2/token/")
    fun postOAuthRequestSMS(
            @Body loginRequestBody: LoginRequestBody?): Single<SMSRequestResponse>

    @POST("oauth2/token/")
    fun postOAuthGetAccessToken(
            @Body loginRequestBody: LoginRequestBody?, @Header(value = "X-ROBINHOOD-CHALLENGE-RESPONSE-ID") challengeResponseID: String): Single<GetAccessTokenResponse>


    @POST("challenge/" + "{challengeID}" + "/respond/")
    fun postOAuthVerifySMS(
            @Body verifyRequest: MFAVerifyRequest?, @Path(value = "challengeID", encoded = true) challengeID: String): Single<SMSVerifyResponse>
    //endregion

    //region Profile APIs
    @GET("accounts/")
    fun getAccounts(
            @Header(value = "Authorization") accessToken: String): Single<GetAccountsResponse>

    @GET("user/basic_info/")
    fun getBasicInfo(
            @Header(value = "Authorization") accessToken: String): Single<GetBasicInfoResponse>

    @GET("user/investment_profile/")
    fun getInvestmentProfile(
            @Header(value = "Authorization") accessToken: String): Single<GetInvestmentProfileResponse>

    @GET("portfolios/")
    fun getPortfolios(
            @Header(value = "Authorization") accessToken: String): Single<GetPortfoliosResponse>

    @GET("user/additional_info/")
    fun getAdditionalInfo(
            @Header(value = "Authorization") accessToken: String): Single<GetAdditionalInfoResponse>

    @GET("user/")
    fun getUser(
            @Header(value = "Authorization") accessToken: String): Single<GetUserResponse>
    //endregion


    //region Account APIs
    @GET("accounts/unified/")
    fun getPhoenixAccount(
            @Header(value = "Authorization") accessToken: String): Single<GetPhoenixAccountResponse>


    @GET("portfolios/historicals/" + "{accountNumber}" + "/")
    fun getHistoricalPortfolio(
            @Header(value = "Authorization") accessToken: String,
            @Path(value = "accountNumber", encoded = true) accountNumber: String,
            @Query(value = "interval", encoded = true) interval: String,
            @Query(value = "span", encoded = true) span: String,
            @Query(value = "bounds", encoded = true) bounds: String)
            : Single<GetHistoricalPortfolioResponse>


    @GET("positions/")
    fun getPositions(
            @Header(value = "Authorization") accessToken: String,
            @Query(value = "nonzero", encoded = true) nonzero: String)
            : Single<GetPositionsResponse>

    @GET("dividends/")
    fun getDividends(
            @Header(value = "Authorization") accessToken: String)
            : Single<GetDividendsResponse>

    @GET("ach/relationships/")
    fun getBankAccounts(
            @Header(value = "Authorization") accessToken: String)
            : Single<GetBankAccountsResponse>

    @GET("ach/relationships/" + "{bankID}" + "/")
    fun getBankAccountInfo(
            @Header(value = "Authorization") accessToken: String,
            @Path(value = "bankID", encoded = true) bankID: String)
            : Single<BankAccountInfoResponse>

    @GET("ach/" + "{direction}" + "transfers/")
    fun getBankTransfers(
            @Header(value = "Authorization") accessToken: String,
            @Path(value = "direction", encoded = true) direction: String)
            : Single<GetBankTransfersResponse>

    @GET("history/transactions/")
    fun getCardTransactions(
            @Header(value = "Authorization") accessToken: String,
            @Query(value = "type ", encoded = true) type: String)
            : Single<GetCardTransactionsResponse>

    @GET("subscription/subscription_fees/")
    fun getSubscriptionFees(
            @Header(value = "Authorization") accessToken: String)
            : Single<GetSubscriptionFeesResponse>


    @GET("midlands/referral/")
    fun getReferrals(
            @Header(value = "Authorization") accessToken: String)
            : Single<GetReferralsResponse>

    @GET("documents/")
    fun getDocuments(
            @Header(value = "Authorization") accessToken: String)
            : Single<GetDocumentsResponse>

    @GET("midlands/lists/default/")
    fun getLists(
            @Header(value = "Authorization") accessToken: String)
            : Single<GetListsResponse>

    @GET("midlands/lists/items/")
    fun getListInfo(
            @Header(value = "Authorization") accessToken: String,
            @Query(value = "list_id", encoded = true) listID : String)
            : Single<GetListInfoResponse>

    @POST("midlands/lists/items/")
    fun postAddSymbolToList(
            @Body postBody: RequestBody,  @Header(value = "Authorization") accessToken: String): Single<Map<String, List<ObjectUnit>>>
    //endregion

    //region Stocks APIs
    @GET("quotes/")
    fun getQuotesBySymbol(
            @Header(value = "Authorization",) accessToken: String, @Query(value = "symbols",encoded = true) symbols: String): Single<GetQuotesResponse>

    @GET("quotes/" + "{symbolID}" + "/")
    fun getQuotesByID(
            @Header(value = "Authorization",) accessToken: String, @Path(value = "symbolID",encoded = true) symbolsID: String): Single<Quote>

    @GET("fundamentals/")
    fun getFundamentals(
            @Header(value = "Authorization",) accessToken: String, @Query(value = "symbols",encoded = true) symbols: String): Single<GetFundametalsResponse>

    @GET("instruments/")
    fun getInstruments(
            @Header(value = "Authorization",) accessToken: String, @Query(value = "symbols",encoded = true) symbols: String): Single<GetInstrumentsResponse>

    @GET("midlands/ratings/")
    fun getRatings(
            @Header(value = "Authorization",) accessToken: String, @Query(value = "symbols",encoded = true) symbols: String): Single<GetRatingsResponse>

    @GET("options/events/")
    fun getEvents(
            @Header(value = "Authorization",) accessToken: String, @Query(value = "equity_instrument_id",encoded = true) instrumentID: String): Single<GetRatingsResponse>


    @GET("marketdata/earnings/")
    fun getEarnings(
            @Header(value = "Authorization",) accessToken: String, @Query(value = "symbol",encoded = true) symbol: String): Single<GetEarningsResponse>

    @GET("midlands/news/" + "{symbol}" + "/")
    fun getNews(
            @Header(value = "Authorization") accessToken: String,
            @Path(value = "symbol", encoded = true) symbol: String)
            : Single<GetNewsResponse>

    @GET("instruments/" + "{symbol}" + "/splits/")
    fun getSplits(
            @Header(value = "Authorization") accessToken: String,
            @Path(value = "symbolID", encoded = true) symbolID: String)
            : Single<GetSplitsResponse>

    @GET("instruments/")
    fun getInstrumentData(
            @Header(value = "Authorization") accessToken: String,
            @Query(value = "query", encoded = true) searchQuery: String)
            : Single<GetInstrumentDataResponse>

    @GET("/marketdata/pricebook/snapshots/" + "{symbolID}" + "/")
    fun getPriceBookByID(
            @Header(value = "Authorization",) accessToken: String, @Path(value = "symbolID",encoded = true) symbolsID: String): Single<GetPriceBookResponse>

//endregion
}
