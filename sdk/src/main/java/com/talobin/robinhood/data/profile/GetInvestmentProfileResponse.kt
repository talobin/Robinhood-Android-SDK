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

data class GetInvestmentProfileResponse(
        @field:SerializedName("annual_income") val annual_income: String,
        @field:SerializedName("interested_in_options") val interestedInOptions: Any,
        @field:SerializedName("investment_experience") val investmentExperience: String,
        @field:SerializedName("investment_experience_collected") val investmentExperienceCollected: Boolean,
        @field:SerializedName("investment_objective") val investmentObjective: String,
        @field:SerializedName("liquid_net_worth") val liquidNetWorth: String,
        @field:SerializedName("liquidity_needs") val liquidityNeeds: String,
        @field:SerializedName("option_trading_experience") val optionTradingExperience: String,
        @field:SerializedName("professional_trader") val professionalTrader: Any,
        @field:SerializedName("risk_tolerance") val riskTolerance: String,
        @field:SerializedName("source_of_funds") val sourceOfFunds: String,
        @field:SerializedName("suitability_verified") val suitabilityVerified: Boolean,
        @field:SerializedName("tax_bracket") val taxBracket: String,
        @field:SerializedName("time_horizon") val timeHorizon: String,
        @field:SerializedName("total_net_worth") val totalNetWorth: String,
        @field:SerializedName("understand_option_spreads") val understandOptionSpreads: Any,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("user") val user: String
)