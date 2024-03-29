package com.kunal.wikipedia.view.pagelist.model


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("height")
    val height: Int,
    @SerializedName("source")
    val source: String,
    @SerializedName("width")
    val width: Int
)