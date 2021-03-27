package com.talobin.robinhood.data.stock

import com.google.gson.annotations.SerializedName

data class GetPriceBookResponse(
        @field:SerializedName("asks") val asks: List<Any>,
        @field:SerializedName("bids") val bids: List<Any>,
        @field:SerializedName("instrument_id") val instrumentId: String,
        @field:SerializedName("updated_at") val updatedAt: String
)