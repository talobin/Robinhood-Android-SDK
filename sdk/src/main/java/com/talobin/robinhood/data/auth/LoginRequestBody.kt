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

private const val SCOPE_INTERNAL = "internal"
private const val EXPIRES_IN = 86400
private const val CLIENT_ID = "c82SH0WZOsabOXGP2sxqcj34FxkvfnWRZBKlBjFS"
private const val CHALLENGE_TYPE_SMS = "sms"
private const val GRANT_TYPE_PASSWORD = "password"
data class LoginRequestBody(
        @field:SerializedName("username") val username: String,
        @field:SerializedName("password") val password: String,
        @field:SerializedName("device_token") val deviceToken: String,
        @field:SerializedName("grant_type") val grantType: String = GRANT_TYPE_PASSWORD,
        @field:SerializedName("scope") val scope: String  = SCOPE_INTERNAL,
        @field:SerializedName("client_id") val clientId: String = CLIENT_ID,
        @field:SerializedName("challenge_type") val challengeType: String = CHALLENGE_TYPE_SMS,
        @field:SerializedName("expires_in") val expiresIn: Int = EXPIRES_IN,
)