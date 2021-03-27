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

data class Fundamental(
        @field:SerializedName("average_volume") val averageVolume: String,
        @field:SerializedName("average_volume_2_weeks") val averageVolume2Weeks: String,
        @field:SerializedName("ceo") val ceo: String,
        @field:SerializedName("description") val description: String,
        @field:SerializedName("dividend_yield") val dividendYield: Any,
        @field:SerializedName("float") val float: String,
        @field:SerializedName("headquarters_city") val headquartersCity: String,
        @field:SerializedName("headquarters_state") val headquartersState: String,
        @field:SerializedName("high") val high: String,
        @field:SerializedName("high_52_weeks") val high52Weeks: String,
        @field:SerializedName("industry") val industry: String,
        @field:SerializedName("instrument") val instrument: String,
        @field:SerializedName("low") val low: String,
        @field:SerializedName("low_52_weeks") val low52Weeks: String,
        @field:SerializedName("market_cap") val marketCap: String,
        @field:SerializedName("market_date") val marketDate: String,
        @field:SerializedName("num_employees") val numEmployees: Int,
        @field:SerializedName("open") val open: String,
        @field:SerializedName("pb_ratio") val pbRatio: String,
        @field:SerializedName("pe_ratio") val peRatio: String,
        @field:SerializedName("sector") val sector: String,
        @field:SerializedName("shares_outstanding") val sharesOutstanding: String,
        @field:SerializedName("volume") val volume: String,
        @field:SerializedName("year_founded") val yearFounded: Int
)