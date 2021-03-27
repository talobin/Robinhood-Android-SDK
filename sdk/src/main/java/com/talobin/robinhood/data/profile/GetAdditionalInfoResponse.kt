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

data class GetAdditionalInfoResponse(
        @field:SerializedName("agreed_to_rhs") val agreedToRhs: Boolean,
        @field:SerializedName("agreed_to_rhs_margin") val agreedToRhsMargin: Boolean,
        @field:SerializedName("control_person") val controlPerson: Boolean,
        @field:SerializedName("control_person_security_symbol") val controlPersonSecuritySymbol: String,
        @field:SerializedName("object_to_disclosure") val objectToDisclosure: Boolean,
        @field:SerializedName("rhs_stock_loan_consent_status") val rhsStockLoanConsentStatus: String,
        @field:SerializedName("security_affiliated_address") val securityAffiliatedAddress: String,
        @field:SerializedName("security_affiliated_address_subject") val securityAffiliatedAddressSubject: Any,
        @field:SerializedName("security_affiliated_employee") val securityAffiliatedEmployee: Boolean,
        @field:SerializedName("security_affiliated_firm_name") val securityAffiliatedFirmName: String,
        @field:SerializedName("security_affiliated_firm_relationship") val securityAffiliatedFirmRelationship: String,
        @field:SerializedName("security_affiliated_person_name") val securityAffiliatedPersonName: String,
        @field:SerializedName("security_affiliated_requires_duplicates") val securityAffiliatedRequiresDuplicates: Any,
        @field:SerializedName("stock_loan_consent_status") val stockLoanConsentStatus: String,
        @field:SerializedName("sweep_consent") val sweepConsent: Boolean,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("user") val user: String
)