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

data class Referral(
        @field:SerializedName("campaign") val campaign: String,
        @field:SerializedName("can_remind") val canRemind: Boolean,
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("direction") val direction: String,
        @field:SerializedName("experiment") val experiment: String,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("other_user") val otherUser: OtherUser,
        @field:SerializedName("remind_url") val remindUrl: String,
        @field:SerializedName("reward") val reward: Reward,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("state_description") val stateDescription: String,
        @field:SerializedName("to_state_received_at") val toStateReceivedAt: Any,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("url") val url: String
)

data class Reward(
        val cash: Any,
        val stocks: List<Stock>
)

data class OtherUser(
        val first_name: String,
        val last_initial: String
)