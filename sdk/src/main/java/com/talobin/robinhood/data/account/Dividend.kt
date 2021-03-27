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

data class Dividend(
        @field:SerializedName("account") val account: String,
        @field:SerializedName("amount") val amount: String,
        @field:SerializedName("drip_enabled") val dripEnabled: Boolean,
        @field:SerializedName("drip_order_execution_price") val dripOrderExecutionPrice: EquityUnit,
        @field:SerializedName("drip_order_id") val dripOrderId: String,
        @field:SerializedName("drip_order_quantity") val dripOrderQuantity: String,
        @field:SerializedName("drip_order_state") val dripOrderState: String,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("instrument") val instrument: String,
        @field:SerializedName("nra_withholding") val nraWithholding: String,
        @field:SerializedName("paid_at") val paidAt: Any,
        @field:SerializedName("payable_date") val payableDate: String,
        @field:SerializedName("position") val position: String,
        @field:SerializedName("rate") val rate: String,
        @field:SerializedName("record_date") val recordDate: String,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("url") val url: String,
        @field:SerializedName("withholding") val withholding: String
)