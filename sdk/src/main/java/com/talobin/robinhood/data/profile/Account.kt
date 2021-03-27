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

data class Account(
        @field:SerializedName("account_number") val accountNumber: String,
        @field:SerializedName("active_subscription_id") val activeSubscriptionId: String,
        @field:SerializedName("amount_eligible_for_deposit_cancellation") val amountEligibleForDepositCancellation: String,
        @field:SerializedName("buying_power") val buyingPower: String,
        @field:SerializedName("can_downgrade_to_cash") val canDowngradeToCash: String,
        @field:SerializedName("cash") val cash: String,
        @field:SerializedName("cash_available_for_withdrawal") val cashAvailableForWithdrawal: String,
        @field:SerializedName("cash_balances") val cashBalances: Any,
        @field:SerializedName("cash_held_for_options_collateral") val cashHeldForOptionsCollateral: String,
        @field:SerializedName("cash_held_for_orders") val cashHeldForOrders: String,
        @field:SerializedName("cash_management_enabled") val cashManagementEnabled: Boolean,
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("crypto_buying_power") val cryptoBuyingPower: String,
        @field:SerializedName("deactivated") val deactivated: Boolean,
        @field:SerializedName("deposit_halted") val depositHalted: Boolean,
        @field:SerializedName("drip_enabled") val dripEnabled: Boolean,
        @field:SerializedName("eligible_for_cash_management") val eligibleForCashManagement: Any,
        @field:SerializedName("eligible_for_drip") val eligibleForDrip: Boolean,
        @field:SerializedName("eligible_for_fractionals") val eligibleForFractionals: Boolean,
        @field:SerializedName("equity_trading_lock") val equityTradingLock: String,
        @field:SerializedName("fractional_position_closing_only") val fractionalPositionClosingOnly: Boolean,
        @field:SerializedName("instant_eligibility") val instantEligibility: InstantEligibility,
        @field:SerializedName("is_pinnacle_account") val isPinnacleAccount: Boolean,
        @field:SerializedName("locked") val locked: Boolean,
        @field:SerializedName("margin_balances") val marginBalances: MarginBalances,
        @field:SerializedName("max_ach_early_access_amount") val maxAchEarlyAccessAmount: String,
        @field:SerializedName("only_position_closing_trades") val onlyPositionClosingTrades: Boolean,
        @field:SerializedName("option_level") val optionLevel: Any,
        @field:SerializedName("option_trading_lock") val optionTradingLock: String,
        @field:SerializedName("option_trading_on_expiration_enabled") val optionTradingOnExpirationEnabled: Boolean,
        @field:SerializedName("permanently_deactivated") val permanently_deactivated: Boolean,
        @field:SerializedName("portfolio_cash") val portfolioCash: String,
        @field:SerializedName("received_ach_debit_locked") val receivedAchDebitLocked: Boolean,
        @field:SerializedName("rhs_account_number") val rhsAccountNumber: Int,
        @field:SerializedName("rhs_stock_loan_consent_status") val rhsStockLoanConsentStatus: String,
        @field:SerializedName("sma") val sma: String,
        @field:SerializedName("sma_held_for_orders") val smaHeldForOrders: String,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("sweep_enabled") val sweepEnabled: Boolean,
        @field:SerializedName("type") val type: String,
        @field:SerializedName("uncleared_deposits") val unclearedDeposits: String,
        @field:SerializedName("unsettled_debit") val unsettledDebit: String,
        @field:SerializedName("unsettled_funds") val unsettledFunds: String,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("url") val url: String,
        @field:SerializedName("user") val user: String,
        @field:SerializedName("user_id") val user_id: String,
        @field:SerializedName("withdrawal_halted") val withdrawalHalted: Boolean
)