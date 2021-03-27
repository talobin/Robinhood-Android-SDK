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

data class Portfolio(
        @field:SerializedName("account") val account: String,
        @field:SerializedName("adjusted_equity_previous_close") val adjustedEquityPreviousClose: String,
        @field:SerializedName("adjusted_portfolio_equity_previous_close") val adjustedPortfolioEquityPreviousClose: String,
        @field:SerializedName("equity") val equity: String,
        @field:SerializedName("equity_previous_close") val equityPreviousClose: String,
        @field:SerializedName("excess_maintenance") val excessMaintenance: String,
        @field:SerializedName("excess_maintenance_with_uncleared_deposits") val excessMaintenanceWithUnclearedDeposits: String,
        @field:SerializedName("excess_margin") val excessMargin: String,
        @field:SerializedName("excess_margin_with_uncleared_deposits") val excessMarginWithUnclearedDeposits: String,
        @field:SerializedName("extended_hours_equity") val extendedHoursEquity: String,
        @field:SerializedName("extended_hours_market_value") val extendedHoursMarketValue: String,
        @field:SerializedName("extended_hours_portfolio_equity") val extendedHoursPortfolioEquity: String,
        @field:SerializedName("last_core_equity") val lastCoreEquity: String,
        @field:SerializedName("last_core_market_value") val lastCoreMarketValue: String,
        @field:SerializedName("last_core_portfolio_equity") val lastCorePortfolioEquity: String,
        @field:SerializedName("market_value") val marketValue: String,
        @field:SerializedName("portfolio_equity_previous_close") val portfolioEquityPreviousClose: String,
        @field:SerializedName("start_date") val startDate: String,
        @field:SerializedName("unwithdrawable_deposits") val unwithdrawableDeposits: String,
        @field:SerializedName("unwithdrawable_grants") val unwithdrawableGrants: String,
        @field:SerializedName("url") val url: String,
        @field:SerializedName("withdrawable_amount") val withdrawableAmount: String
)