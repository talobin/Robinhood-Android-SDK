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

data class SubscriptionFee(
        @field:SerializedName("amount") val amount: String,
        @field:SerializedName("carry_forward_credit") val carryForwardCredit: String,
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("credit") val credit: String,
        @field:SerializedName("date") val date: String,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("refunds") val refunds: List<Any>,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("subscription") val subscription: String,
        @field:SerializedName("url") val url: String
)