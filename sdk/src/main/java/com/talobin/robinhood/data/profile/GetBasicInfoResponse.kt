/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        @field:SerializedName("next")  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.talobin.robinhood.data.profile

import com.google.gson.annotations.SerializedName

data class GetBasicInfoResponse(
        @field:SerializedName("address") val address: String,
        @field:SerializedName("citizenship") val citizenship: String,
        @field:SerializedName("city") val city: String,
        @field:SerializedName("country_of_residence") val countryOfResidence: String,
        @field:SerializedName("date_of_birth") val dateOfBirth: String,
        @field:SerializedName("marital_status") val maritalStatus: String,
        @field:SerializedName("number_dependents") val numberDependents: Int,
        @field:SerializedName("phone_number") val phoneNumber: String,
        @field:SerializedName("signup_as_rhs") val signupAsRhs: Boolean,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("tax_id_ssn") val taxIdSsn: String,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("user") val user: String,
        @field:SerializedName("zipcode") val zipcode: String
)