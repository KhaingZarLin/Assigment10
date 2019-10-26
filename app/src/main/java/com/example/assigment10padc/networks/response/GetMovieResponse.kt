package com.example.assigment10padc.networks.response

import com.example.assigment10padc.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

data class GetMovieResponse (
    @SerializedName("page")
    val page:Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<MovieVO>)

