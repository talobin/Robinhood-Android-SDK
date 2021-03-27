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

data class BankAccountInfoResponse(
        @field:SerializedName("account") val account: String,
        @field:SerializedName("bank_account_holder_name") val bankAccountHolderName: String,
        @field:SerializedName("bank_account_nickname") val bankAccountNickname: String,
        @field:SerializedName("bank_account_number") val bankAccountNumber: String,
        @field:SerializedName("bank_account_type") val bankAccountType: String,
        @field:SerializedName("bank_routing_number") val bankRoutingNumber: String,
        @field:SerializedName("created_at") val createdAt: String,
        @field:SerializedName("document_request") val documentRequest: Any,
        @field:SerializedName("first_created_at") val firstCreatedAt: String,
        @field:SerializedName("id") val id: String,
        @field:SerializedName("initial_deposit") val initialDeposit: String,
        @field:SerializedName("state") val state: String,
        @field:SerializedName("unlink") val unlink: String,
        @field:SerializedName("unlinked_at") val unlinkedAt: Any,
        @field:SerializedName("url") val url: String,
        @field:SerializedName("verification_method") val verificationMethod: String,
        @field:SerializedName("verified") val verified: Boolean,
        @field:SerializedName("verify_micro_deposits") val verifyMicroDeposits: Any,
        @field:SerializedName("withdrawal_limit") val withdrawalLimit: String
)