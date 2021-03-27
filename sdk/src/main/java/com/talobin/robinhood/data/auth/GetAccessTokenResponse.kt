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


data class GetAccessTokenResponse(

    @field:SerializedName("access_token") val accessToken: String,
    @field:SerializedName("expires_in") val expiresIn: Int,
    @field:SerializedName("token_type") val tokenType: String,
    @field:SerializedName("scope") val scope: String,
    @field:SerializedName("refresh_token") val refreshToken: String,
    @field:SerializedName("mfa_code") val MFACode: String,
    @field:SerializedName("backup_code") val backupCode: String,

    )
fun GetAccessTokenResponse.getAccessString() = tokenType + " " + accessToken