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

package com.talobin.robinhood.data.stock

import com.google.gson.annotations.SerializedName

data class News(
        @field:SerializedName("api_source") val apiSource: String,
        @field:SerializedName("author") val author: String,
        @field:SerializedName("currency_id") val currencyId: String,
        @field:SerializedName("num_clicks") val numClicks: Int,
        @field:SerializedName("preview_image_url") val previewImageUrl: String,
        @field:SerializedName("preview_text") val previewText: String,
        @field:SerializedName("published_at") val publishedAt: String,
        @field:SerializedName("related_instruments") val relatedInstruments: List<String>,
        @field:SerializedName("relay_url") val relayUrl: String,
        @field:SerializedName("source") val source: String,
        @field:SerializedName("summary") val summary: String,
        @field:SerializedName("title") val title: String,
        @field:SerializedName("updated_at") val updatedAt: String,
        @field:SerializedName("url") val url: String,
        @field:SerializedName("uuid") val uuid: String
)