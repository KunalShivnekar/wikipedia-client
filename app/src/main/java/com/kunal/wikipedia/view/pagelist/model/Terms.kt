package com.kunal.wikipedia.view.pagelist.model


import com.google.gson.annotations.SerializedName

data class Terms(
    @SerializedName("description")
    val description: List<String>
)