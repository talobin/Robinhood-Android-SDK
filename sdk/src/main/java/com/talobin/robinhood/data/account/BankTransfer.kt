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

data class BankTransfer(
        @field:SerializedName("account") val account: String,
        @field:SerializedName("ach_relationship") val achRelationship: String,
        @field:SerializedName("amount") val amount: String,
        @field:SerializedName("cancel") val cancel: Any,
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("direction") val direction: String,
        @field:SerializedName("early_access_amount") val earlyAccessAmount: String,
        @field:SerializedName("expected_landing_date") val expectedLandingDate: String,
        @field:SerializedName("expected_landing_datetime") val expectedLandingDatetime: String,
        @field:SerializedName("expected_sweep_at") val expectedSweepAt: Any,
        @field:SerializedName("fees") val fees: String,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("investment_schedule_id") val investmentScheduleId: Any,
        @field:SerializedName("ref_id") val refId: String,
        @field:SerializedName("rhs_state") val rhsState: String,
        @field:SerializedName("scheduled") val scheduled: Boolean,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("status_description") val statusDescription: String,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("url") val url: String
)