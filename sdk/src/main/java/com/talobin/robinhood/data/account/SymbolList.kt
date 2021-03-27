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

data class SymbolList(
            @field:SerializedName("child_info") val childInfo: ChildInfo,
            @field:SerializedName("child_sort_direction") val childSortDirection: String,
            @field:SerializedName("child_sort_order") val childSortOrder: String,
            @field:SerializedName("created_at") val createdAt: String,
            @field:SerializedName("default_expanded") val defaultExpanded: Boolean,
            @field:SerializedName("display_description") val displayDescription: Any,
            @field:SerializedName("display_name") val displayName: String,
            @field:SerializedName("followed") val followed: Boolean,
            @field:SerializedName("hero_images") val heroImages: Any,
            @field:SerializedName("icon_emoji") val iconEmoji: String,
            @field:SerializedName("id") val id: String,
            @field:SerializedName("item_count") val itemCount: Int,
            @field:SerializedName("owner") val owner: String,
            @field:SerializedName("owner_type") val ownerType: String,
            @field:SerializedName("parent_lists") val parentLists: List<Any>,
            @field:SerializedName("read_permission") val readPermission: String,
            @field:SerializedName("related_lists") val relatedLists: List<Any>,
            @field:SerializedName("updated_at") val updatedAt: String
)