package com.example.assigment10padc.mvp.presenter

import androidx.lifecycle.Observer
import com.example.assigment10padc.fragment.BaseFragment
import com.example.assigment10padc.mvp.views.MovieView

class MoviePresenter : BasePresenter<MovieView>() {


    fun onUiReady(fragment: BaseFragment) {
        model.getTopRatedMovies()
            .observe(fragment, Observer {
                mView.showTopRatedMovie(it)
            })

        model.getPopularMovies()
            .observe(fragment, Observer {
                mView.showPopularMovie(it)
            })

        model.getUpComingMovies()
            .observe(fragment, Observer {
                mView.showUpcomingMovie(it)
            })

        model.getNowPlayingMovies()
            .observe(fragment, Observer {
                mView.showNowPlayingMovie(it)
            })
    }

}