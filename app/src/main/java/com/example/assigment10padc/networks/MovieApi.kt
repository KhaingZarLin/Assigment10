package com.example.assigment10padc.networks

import com.example.assigment10padc.data.vos.MovieDetailVO
import com.example.assigment10padc.networks.response.*
import com.example.assigment10padc.utilites.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApi {

    @GET(GET_NOW_PLAYING)
    fun getNowPlayingMovies(@Query(PARAM_PAGE) page:Int = 1): Call<GetNowPlayingMovieResponse>

    @GET(GET_POPULAR)
    fun getPopularMovies(@Query(PARAM_PAGE) page:Int = 1): Call<GetPopularMovieResponse>

    @GET(Get_TOP_RATED)
    fun getTopRatedMovies(@Query(PARAM_PAGE) page:Int = 1): Call<GetTopRatedMovieResponse>

    @GET(GET_UPCOMING)
    fun getUpComingMovies(@Query(PARAM_PAGE) page:Int = 1): Call<GetUpcomingMovieResponse>

    @GET(GET_SIMILAR_MOVIE)
    fun getSimilarMovies(@Path("id") id: Int): Call<GetSimilarMovieResponse>

    @GET(Get_Movie_Videos)
    fun getTrailer(@Path("id") id: Int): Call<TrailerVideoResponse>

    @GET(GET_MOVIE_DETAIL)
    fun getMovieDetail(@Path("id") id: Int): Call<MovieDetailVO>

}