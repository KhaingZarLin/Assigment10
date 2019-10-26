package com.example.assigment10padc.networks.response

import com.example.assigment10padc.data.vos.MovieVO
import com.google.gson.annotations.SerializedName


data class GetSimilarMovieResponse(

    @SerializedName("page")
    val page:Int,
    @SerializedName("results")
    val results: List<MovieVO>
)