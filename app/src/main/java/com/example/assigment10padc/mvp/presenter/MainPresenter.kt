package com.example.assigment10padc.mvp.presenter

import com.example.assigment10padc.delegates.MovieDelegate
import com.example.assigment10padc.mvp.views.MainView

class MainPresenter: BasePresenter<MainView>(), MovieDelegate {
    override fun onTabEventItem(movieId: Int) {
         mView.navigateToMovieDetail(movieId)
        }

}