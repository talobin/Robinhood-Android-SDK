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

package com.talobin.robinhood.data

import com.google.gson.annotations.SerializedName

data class GetUserResponse(
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("email") val email: String,
        @field:SerializedName("email_verified") val emailVerified: Boolean,
        @field:SerializedName("first_name") val firstName: String,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("id_info") val idInfo: String,
        @field:SerializedName("last_name") val lastName: String,
        @field:SerializedName("origin") val origin: Origin,
        @field:SerializedName("profile_name") val profileName: String,
        @field:SerializedName("url") val url: String,
        @field:SerializedName("username") val username: String
)

data class Origin(
        @field:SerializedName("locality") val locality: String
)