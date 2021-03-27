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

data class Equities(
        @field:SerializedName("active_subscription_id") val active_subscription_id: String,
        @field:SerializedName("apex_account_number") val apex_account_number: String,
        @field:SerializedName("available_margin") val available_margin: Any,
        @field:SerializedName("equity") val equity: EquityUnit,
        @field:SerializedName("margin_maintenance") val marginMaintenance: EquityUnit,
        @field:SerializedName("market_value") val marketValue: EquityUnit,
        @field:SerializedName("opened_at") val openedAt: String,
        @field:SerializedName("rhs_account_number") val rhsAccountNumber: String,
        @field:SerializedName("total_margin") val totalMargin: EquityUnit
)