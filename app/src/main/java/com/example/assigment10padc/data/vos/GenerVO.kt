package com.example.assigment10padc.data.vos

import com.google.gson.annotations.SerializedName

data class GenerVO (
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)