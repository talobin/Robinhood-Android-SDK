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

data class InstantEligibility(
        @field:SerializedName("additional_deposit_needed") val additionalDepositNeeded: String,
        @field:SerializedName("compliance_user_major_oak_email") val complianceUserMajorOakEmail: Any,
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("created_by") val createdBy: Any,
        @field:SerializedName("reason") val reason: String,
        @field:SerializedName("reinstatement_date")  val reinstatementDate: Any,
        @field:SerializedName("reversal") val reversal: Any,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("updated_at")  val updatedAt: Any
)