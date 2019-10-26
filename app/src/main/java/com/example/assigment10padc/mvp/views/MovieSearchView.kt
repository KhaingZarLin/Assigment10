package com.example.assigment10padc.mvp.views

import com.example.assigment10padc.data.vos.MovieVO

interface MovieSearchView: BaseView {
    fun displayMovies(movies: List<MovieVO>)
    fun errorMessage(message: String)
}