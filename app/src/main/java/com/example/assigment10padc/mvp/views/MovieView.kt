package com.example.assigment10padc.mvp.views

import com.example.assigment10padc.data.vos.MovieVO

interface MovieView:BaseView {

    //fun navigateToMovieDetail(movieId: Int)
    fun showTopRatedMovie(movies: List<MovieVO>)
    fun showPopularMovie(movies: List<MovieVO>)
    fun showUpcomingMovie(movies: List<MovieVO>)
    fun showNowPlayingMovie(movies: List<MovieVO>)
    fun errorMessage(errorMessage: String)

}