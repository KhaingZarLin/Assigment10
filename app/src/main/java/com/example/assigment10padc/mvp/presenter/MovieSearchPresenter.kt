package com.example.assigment10padc.mvp.presenter

import com.example.assigment10padc.fragment.BaseFragment
import com.example.assigment10padc.mvp.views.MovieSearchView
import java.util.Observer

class MovieSearchPresenter: BasePresenter<MovieSearchView>() {

    private lateinit var fragment: BaseFragment

    fun onUiReady(fragment: BaseFragment) {

        this.fragment = fragment

        model.getAllMovies().observe(this.fragment,androidx.lifecycle.Observer { mView.displayMovies(it) })


    }
}