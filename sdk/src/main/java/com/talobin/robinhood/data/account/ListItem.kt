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

data class ListItem(
        @field:SerializedName("created_at") val created_at: String,
        @field:SerializedName("holdings") val holdings: Boolean,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("list_id") val listId: String,
        @field:SerializedName("market_cap") val marketCap: Double,
        @field:SerializedName("name") val name: String,
        @field:SerializedName("object_id") val objectId: String,
        @field:SerializedName("object_type") val objectType: String,
        @field:SerializedName("one_day_dollar_change") val oneDayDollarChange: Double,
        @field:SerializedName("one_day_percent_change") val oneDayPercentChange: Double,
        @field:SerializedName("one_day_rolling_dollar_change") val oneDayRollingDollarChange: Double,
        @field:SerializedName("one_day_rolling_percent_change") val oneDayRollingPercentChange: Double,
        @field:SerializedName("open_positions") val openPositions: Int,
        @field:SerializedName("owner_type") val ownerType: String,
        @field:SerializedName("price") val price: Double,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("symbol") val symbol: String,
        @field:SerializedName("uk_tradability") val ukTradability: String,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("us_tradability") val usTradability: String,
        @field:SerializedName("weight") val weight: String
)