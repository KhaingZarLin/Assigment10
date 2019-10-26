package com.example.assigment10padc.mvp.views

import com.example.assigment10padc.data.vos.MovieDetailVO
import com.example.assigment10padc.data.vos.MovieVO

interface DetailView:BaseView {

    fun displayMovieDetail(movieDetail: MovieDetailVO)
    fun displaySimilarMovies(movies: List<MovieVO>)
    fun showTrailers()
    fun errorMessage(errorMessage: String)
}