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

package com.talobin.robinhood.util

object RandomQueryGenerator {
    val charArray = arrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

    var oneCharIndex = -1
    val twoCharIndices = arrayOf(0, -1)
    val threeCharIndices = arrayOf(0, 0, -1)
    val fourCharIndices = arrayOf(0, 0, 0, -1)

    fun init() {
        oneCharIndex = -1

    }

    fun getNextQuery(): String {
        if (isDoneWithOneLetter()) {
            if (isDoneWithTwoLetter()) {
                if (isDoneWithThreeLetter()) {
                    return if (isDoneWithFourLetter()) {
                        ""
                    } else {
                        getNextFourLetterQuery()
                    }
                } else {
                    return getNextThreeLetterQuery()
                }
            } else {
                return getNextTwoLetterQuery()
            }
        } else {
            return getNextOneLetterQuery()
        }
    }


    private fun getNextOneLetterQuery(): String {
        oneCharIndex++
        if (oneCharIndex >= charArray.size) {
            oneCharIndex = 0
        }
        return charArray[oneCharIndex].toString()
    }

    private fun isDoneWithOneLetter(): Boolean {
        return isAtLimit(oneCharIndex)
    }

    private fun isDoneWithTwoLetter(): Boolean {
        for (i in twoCharIndices.indices) {
            if (!isAtLimit(twoCharIndices[i])) {
                return false
            }
        }
        return true
    }

    private fun isDoneWithThreeLetter(): Boolean {
        for (i in threeCharIndices.indices) {
            if (!isAtLimit(threeCharIndices[i])) {
                return false
            }
        }
        return true
    }

    private fun isDoneWithFourLetter(): Boolean {
        for (i in fourCharIndices.indices) {
            if (!isAtLimit(fourCharIndices[i])) {
                return false
            }
        }
        return true
    }

    private fun getNextTwoLetterQuery(): String {
        for (i in twoCharIndices.indices) {
            val reversed = twoCharIndices.size - i - 1
            if (isAtLimit(twoCharIndices[reversed])) {
                twoCharIndices[reversed] = 0
            } else {
                twoCharIndices[reversed]++
                break
            }
        }
        val chars = charArrayOf(charArray[twoCharIndices[0]], charArray[twoCharIndices[1]])
        return String(chars)
    }

    private fun getNextThreeLetterQuery(): String {
        for (i in threeCharIndices.indices) {
            val reversed = threeCharIndices.size - i - 1
            if (isAtLimit(threeCharIndices[reversed])) {
                threeCharIndices[reversed] = 0
            } else {
                threeCharIndices[reversed]++
                break
            }
        }
        val chars = charArrayOf(charArray[threeCharIndices[0]], charArray[threeCharIndices[1]], charArray[threeCharIndices[2]])
        return String(chars)
    }

    private fun getNextFourLetterQuery(): String {
        for (i in fourCharIndices.indices) {
            val reversed = fourCharIndices.size - i - 1
            if (isAtLimit(fourCharIndices[reversed])) {
                fourCharIndices[reversed] = 0
            } else {
                fourCharIndices[reversed]++
                break
            }
        }
        val chars = charArrayOf(charArray[fourCharIndices[0]], charArray[fourCharIndices[1]], charArray[fourCharIndices[2]], charArray[fourCharIndices[3]])
        return String(chars)
    }

    private fun isAtLimit(index: Int): Boolean {
        return index >= (charArray.size - 1)
    }

}