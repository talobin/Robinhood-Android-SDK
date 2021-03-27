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

data class Transaction(
        @field:SerializedName("account_id") val account_id: String,
        @field:SerializedName("val") val amount: EquityUnit,
        @field:SerializedName("direction") val direction: String,
        @field:SerializedName("event_type") val eventType: String,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("initiated_at") val initiatedAt: String,
        @field:SerializedName("record_date") val recordDate: String,
        @field:SerializedName("source_id") val sourceId: String,
        @field:SerializedName("source_type") val sourceType: String,
        @field:SerializedName("transaction_code") val transactionCode: String,
        @field:SerializedName("transaction_type") val transactionType: String
)