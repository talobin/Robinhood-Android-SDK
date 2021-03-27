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

const val OBJECT_TYPE_INSTRUMENT = "instrument"
const val OPERATION_CREATE = "create"
const val OPERATION_DELETE = "delete"
data class ObjectUnit(
        @field:SerializedName("object_id") val object_id: String,
        @field:SerializedName("object_type") val object_type: String,
        @field:SerializedName("operation") val operation: String
)