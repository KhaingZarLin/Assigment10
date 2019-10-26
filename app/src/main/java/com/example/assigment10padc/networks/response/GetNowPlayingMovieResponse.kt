package com.example.assigment10padc.networks.response

import com.example.assigment10padc.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

data class GetNowPlayingMovieResponse(

    @SerializedName("results")
    val results: List<MovieVO>
)