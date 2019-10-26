package com.example.assigment10padc.networks.datagents

import com.example.assigment10padc.data.vos.MovieDetailVO
import com.example.assigment10padc.data.vos.MovieVO
import com.example.assigment10padc.networks.response.TrailerVideoResponse

interface MovieDataAgents {
    fun getNowPlayingMovies(
        page: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getPopularMovies(
        page: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getTopRatedMovies(
        page: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getUpComingMovies(
        page: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getTrailerVideos(
        movieId: Int,
        onSuccess: (TrailerVideoResponse) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getMovieDetail(
        id: Int,
        onSuccess: (MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getSimilarMovies(
        id: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
}