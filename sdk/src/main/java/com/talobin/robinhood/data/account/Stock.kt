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

data class Stock(
    val claimable: Boolean,
    val cost_basis: Any,
    val instrument_url: Any,
    val instrument_uuid: Any,
    val quantity: Double,
    val random: Boolean,
    val received_at: Any,
    val state: String,
    val state_description: String,
    val symbol: Any,
    val uuid: Any
)