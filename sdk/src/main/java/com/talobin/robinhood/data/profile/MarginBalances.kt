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

package com.talobin.robinhood.data.profile

import com.google.gson.annotations.SerializedName

data class MarginBalances(
        @field:SerializedName("cash") val cash: String,
        @field:SerializedName("cash_available_for_withdrawal") val cashAvailableForWithdrawal: String,
        @field:SerializedName("cash_held_for_dividends") val cashHeldForDividends: String,
        @field:SerializedName("cash_held_for_nummus_restrictions") val cashHeldForNummusRestrictions: String,
        @field:SerializedName("cash_held_for_options_collateral") val cashHeldForOptionsCollateral: String,
        @field:SerializedName("cash_held_for_orders") val cashHeldForOrders: String,
        @field:SerializedName("cash_held_for_restrictions") val cashHeldForRestrictions: String,
        @field:SerializedName("cash_pending_from_options_events") val cashPendingFromOptionsEvents: String,
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("crypto_buying_power") val cryptoBuyingPower: String,
        @field:SerializedName("day_trade_buying_power") val dayTradeBuyingPower: String,
        @field:SerializedName("day_trade_buying_power_held_for_orders") val dayTradeBuyingPowerHeldForOrders: String,
        @field:SerializedName("day_trade_ratio")  val dayTradeRatio: String,
        @field:SerializedName("day_trades_protection") val dayTradesProtection: Boolean,
        @field:SerializedName("eligible_deposit_as_instant") val eligibleDepositAsInstant: String,
        @field:SerializedName("funding_hold_balance") val fundingHoldBalance: String,
        @field:SerializedName("gold_equity_requirement") val goldEquityRequirement: String,
        @field:SerializedName("instant_allocated")  val instantAllocated: String,
        @field:SerializedName("instant_used") val instantUsed: String,
        @field:SerializedName("margin_limit") val marginLimit: String,
        @field:SerializedName("margin_withdrawal_limit") val marginWithdrawalLimit: Any,
        @field:SerializedName("marked_pattern_day_trader_date") val markedPatternDayTraderDate: String,
        @field:SerializedName("net_moving_cash") val netMovingCash: String,
        @field:SerializedName("outstanding_interest") val outstandingInterest: String,
        @field:SerializedName("overnight_buying_power") val overnightBuyingPower: String,
        @field:SerializedName("overnight_buying_power_held_for_orders") val overnightBuyingPowerHeldForOrders: String,
        @field:SerializedName("overnight_ratio") val overnightRatio: String,
        @field:SerializedName("pending_debit_card_debits") val pendingDebitCardDebits: String,
        @field:SerializedName("pending_deposit") val pendingDeposit: String,
        @field:SerializedName("portfolio_cash") val portfolioCash: String,
        @field:SerializedName("settled_amount_borrowed") val settledAmountBorrowed: String,
        @field:SerializedName("sma") val sma: String,
        @field:SerializedName("start_of_day_dtbp") val startOfDayDtbp: String,
        @field:SerializedName("start_of_day_overnight_buying_power") val startOfDayOvernightBuyingPower: String,
        @field:SerializedName("unallocated_margin_cash") val unallocatedMarginCash: String,
        @field:SerializedName("uncleared_deposits") val unclearedDeposits: String,
        @field:SerializedName("uncleared_nummus_deposits") val unclearedNummusDeposits: String,
        @field:SerializedName("unsettled_debit") val unsettledDebit: String,
        @field:SerializedName("unsettled_funds") val unsettledFunds: String,
        @field:SerializedName("updated_at") val updatedAt: String
)