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

package com.talobin.robinhood.data.auth

import com.google.gson.annotations.SerializedName

const val VALIDATED = "validated"

data class SMSVerifyResponse(

    @field:SerializedName("id") val id: String,
    @field:SerializedName("user") val user: String,
    @field:SerializedName("type") val type: String,
    @field:SerializedName("alternate_type") val alternate_type: String,
    @field:SerializedName("status") val status: String,
    @field:SerializedName("remaining_retries") val remainingRetries: Int,
    @field:SerializedName("remaining_attempts") val remainingAttempts: Int,
    @field:SerializedName("expires_at") val expiresAt: String,
    @field:SerializedName("updated_at") val updatedAt: String,

)

