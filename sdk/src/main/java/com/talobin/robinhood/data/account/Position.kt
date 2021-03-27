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

package com.talobin.robinhood.data.account

import com.google.gson.annotations.SerializedName

data class Position(
        @field:SerializedName("account") val account: String,
        @field:SerializedName("account_number") val accountNumber: String,
        @field:SerializedName("average_buy_price") val averageBuyPrice: String,
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("instrument") val instrument: String,
        @field:SerializedName("intraday_average_buy_price") val intradayAverageBuyPrice: String,
        @field:SerializedName("intraday_quantity") val intradayQuantity: String,
        @field:SerializedName("pending_average_buy_price") val pendingAverageBuyPrice: String,
        @field:SerializedName("quantity") val quantity: String,
        @field:SerializedName("shares_available_for_closing_short_position") val sharesAvailableForClosingShortPosition: String,
        @field:SerializedName("shares_available_for_exercise") val sharesAvailableForExercise: String,
        @field:SerializedName("shares_held_for_buys") val sharesHeldForBuys: String,
        @field:SerializedName("shares_held_for_options_collateral") val shares_held_for_options_collateral: String,
        @field:SerializedName("shares_held_for_options_events") val sharesHeldForOptionsEvents: String,
        @field:SerializedName("shares_held_for_sells") val sharesHeldForSells: String,
        @field:SerializedName("shares_held_for_stock_grants") val sharesHeldForStockGrants: String,
        @field:SerializedName("shares_pending_from_options_events") val sharesPendingFromOptionsEvents: String,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("url") val url: String
)