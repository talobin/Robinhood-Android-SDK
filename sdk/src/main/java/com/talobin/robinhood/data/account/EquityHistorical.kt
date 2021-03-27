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

data class EquityHistorical(
        @field:SerializedName("adjusted_close_equity") val adjustedCloseEquity: String,
        @field:SerializedName("adjusted_open_equity") val adjustedOpenEquity: String,
        @field:SerializedName("begins_at") val beginsAt: String,
        @field:SerializedName("close_equity") val closeEquity: String,
        @field:SerializedName("close_market_value") val closeMarketValue: String,
        @field:SerializedName("net_return") val netReturn: String,
        @field:SerializedName("open_equity") val openEquity: String,
        @field:SerializedName("open_market_value") val openMarketValue: String,
        @field:SerializedName("session") val session: String
)