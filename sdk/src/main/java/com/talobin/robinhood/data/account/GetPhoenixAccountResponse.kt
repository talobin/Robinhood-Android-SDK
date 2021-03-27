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
import com.talobin.robinhood.data.common.EquityUnit

data class GetPhoenixAccountResponse(
        @field:SerializedName("account_buying_power") val accountBuyingPower: EquityUnit,
        @field:SerializedName("cash_available_from_instant_deposits") val cashAvailableFromInstantDeposits: EquityUnit,
        @field:SerializedName("cash_held_for_currency_orders") val cashHeldForCurrencyOrders: EquityUnit,
        @field:SerializedName("cash_held_for_dividends") val cashHeldForDividends: EquityUnit,
        @field:SerializedName("cash_held_for_equity_orders") val cashHeldForEquityOrders: EquityUnit,
        @field:SerializedName("cash_held_for_options_collateral") val cashHeldForOptionsCollateral: EquityUnit,
        @field:SerializedName("cash_held_for_orders") val cashHeldForOrders: EquityUnit,
        @field:SerializedName("crypto") val crypto: Crypto,
        @field:SerializedName("crypto_buying_power") val cryptoBuyingPower: EquityUnit,
        @field:SerializedName("equities") val equities: Equities,
        @field:SerializedName("extended_hours_portfolio_equity") val extendedHoursPortfolioEquity: EquityUnit,
        @field:SerializedName("instant_allocated") val instantAllocated: EquityUnit,
        @field:SerializedName("levered_amount") val leveredAmount: EquityUnit,
        @field:SerializedName("near_margin_call") val nearMarginCall: Boolean,
        @field:SerializedName("options_buying_power") val optionsBuyingPower: EquityUnit,
        @field:SerializedName("portfolio_equity") val portfolioEquity: EquityUnit,
        @field:SerializedName("portfolio_previous_close") val portfolioPreviousClose: EquityUnit,
        @field:SerializedName("previous_close") val previousClose: EquityUnit,
        @field:SerializedName("regular_hours_portfolio_equity") val regularHoursPortfolioEquity: EquityUnit,
        @field:SerializedName("total_equity") val totalEquity: EquityUnit,
        @field:SerializedName("total_extended_hours_equity") val totalExtendedHoursEquity: EquityUnit,
        @field:SerializedName("total_extended_hours_market_value") val totalExtendedHoursMarketValue: EquityUnit,
        @field:SerializedName("total_market_value") val totalMarketValue: EquityUnit,
        @field:SerializedName("total_regular_hours_equity") val totalRegularHoursEquity: EquityUnit,
        @field:SerializedName("total_regular_hours_market_value") val totalRegularHoursMarketValue: EquityUnit,
        @field:SerializedName("uninvested_cash") val uninvestedCash: EquityUnit,
        @field:SerializedName("withdrawable_cash") val withdrawableCash: EquityUnit
)
