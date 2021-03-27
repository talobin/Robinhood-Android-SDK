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

data class Instruments(
        @field:SerializedName("bloomberg_unique") val bloombergUnique: String,
        @field:SerializedName("country") val country: String,
        @field:SerializedName("day_trade_ratio") val dayTradeRatio: String,
        @field:SerializedName("default_collar_fraction") val defaultCollarFraction: String,
        @field:SerializedName("fractional_tradability") val fractionalTradability: String,
        @field:SerializedName("fundamentals") val fundamentals: String,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("ipo_access_cob_deadline") val ipoAccessCobDeadline: Any,
        @field:SerializedName("ipo_access_status") val ipoAccessStatus: Any,
        @field:SerializedName("ipo_allocated_price") val ipoAllocatedPrice: Any,
        @field:SerializedName("ipo_customers_received") val ipoCustomersReceived: Any,
        @field:SerializedName("ipo_customers_requested") val ipoCustomersRequested: Any,
        @field:SerializedName("ipo_date") val ipoDate: Any,
        @field:SerializedName("ipo_s1_url") val ipoS1Url: Any,
        @field:SerializedName("is_spac") val isSpac: Boolean,
        @field:SerializedName("is_test") val isTest: Boolean,
        @field:SerializedName("list_date") val listDate: String,
        @field:SerializedName("maintenance_ratio") val maintenanceRatio: String,
        @field:SerializedName("margin_initial_ratio") val marginInitialRatio: String,
        @field:SerializedName("market") val market: String,
        @field:SerializedName("min_tick_size") val minTickSize: Any,
        @field:SerializedName("name") val name: String,
        @field:SerializedName("quote") val quote: String,
        @field:SerializedName("rhs_tradability") val rhsTradability: String,
        @field:SerializedName("simple_name") val simpleName: String,
        @field:SerializedName("splits") val splits: String,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("symbol") val symbol: String,
        @field:SerializedName("tradability") val tradability: String,
        @field:SerializedName("tradable_chain_id") val tradableChainId: Any,
        @field:SerializedName("tradeable") val tradeable: Boolean,
        @field:SerializedName("type") val type: String,
        @field:SerializedName("url") val url: String
)