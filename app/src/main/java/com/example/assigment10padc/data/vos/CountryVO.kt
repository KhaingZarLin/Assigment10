package com.example.assigment10padc.data.vos

import com.google.gson.annotations.SerializedName

data class CountryVO (
    @SerializedName("iso_3166_1")
    val iso: String,

    @SerializedName("name")
    val name: String
)