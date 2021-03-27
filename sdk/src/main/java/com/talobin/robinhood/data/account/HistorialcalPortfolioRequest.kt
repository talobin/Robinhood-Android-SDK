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

class HistorialcalPortfolioRequest {
    enum class Interval(val value: String) {
        MINUTE_5("5minute"),
        MINUTE_10("10minute"),
        HOUR("hour"),
        DAY("day"),
        WEEK("week")
    }

    enum class Span(val value: String) {
        DAY("day"),
        WEEK("week"),
        MONTH("month"),
        MONTH_3("3month"),
        YEAR("year"),
        YEAR_5("5year"),
        ALL("all")
    }

    enum class Bounds(val value: String) {
        EXTENDED("extended"),
        REGULAR("regular"),
        TRADING("trading")
    }
}