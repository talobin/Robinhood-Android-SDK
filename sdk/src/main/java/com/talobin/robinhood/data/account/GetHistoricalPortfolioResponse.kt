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

data class GetHistoricalPortfolioResponse(
        @field:SerializedName("adjusted_open_equity") val adjustedOpenEquity: String,
        @field:SerializedName("adjusted_previous_close_equity") val adjustedPreviousCloseEquity: String,
        @field:SerializedName("bounds") val bounds: String,
        @field:SerializedName("equity_historicals") val equityHistoricals: List<EquityHistorical>,
        @field:SerializedName("interval") val interval: String,
        @field:SerializedName("open_equity") val openEquity: String,
        @field:SerializedName("open_time") val openTime: String,
        @field:SerializedName("previous_close_equity") val previousCloseEquity: String,
        @field:SerializedName("span") val span: String,
        @field:SerializedName("total_return") val totalReturn: String,
        @field:SerializedName("use_new_hp") val useNewHp: Boolean
)