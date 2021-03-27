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

package com.talobin.robinhood.data.stock

import com.google.gson.annotations.SerializedName

data class Quote(
        @field:SerializedName("adjusted_previous_close") val adjustedPreviousClose: String,
        @field:SerializedName("ask_price") val askPrice: String,
        @field:SerializedName("ask_size") val askSize: Int,
        @field:SerializedName("bid_price") val bidPrice: String,
        @field:SerializedName("bid_size") val bidSize: Int,
        @field:SerializedName("has_traded") val hasTraded: Boolean,
        @field:SerializedName("instrument") val instrument: String,
        @field:SerializedName("instrument_id") val instrumentId: String,
        @field:SerializedName("last_extended_hours_trade_price") val lastExtendedHoursTradePrice: String,
        @field:SerializedName("last_trade_price") val lastTradePrice: String,
        @field:SerializedName("last_trade_price_source") val lastTradePriceSource: String,
        @field:SerializedName("previous_close") val previousClose: String,
        @field:SerializedName("previous_close_date") val previousCloseDate: String,
        @field:SerializedName("symbol") val symbol: String,
        @field:SerializedName("trading_halted") val tradingHalted: Boolean,
        @field:SerializedName("updated_at") val updatedAt: String
)