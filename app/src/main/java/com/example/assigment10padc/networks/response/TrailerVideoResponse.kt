package com.example.assigment10padc.networks.response

import com.example.assigment10padc.data.vos.TrailerVideoVO
import com.google.gson.annotations.SerializedName

data class TrailerVideoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<TrailerVideoVO>
)