package com.example.assigment10padc.mvp.presenter

import com.example.assigment10padc.fragment.BaseFragment
import com.example.assigment10padc.mvp.views.DetailView
import com.example.assigment10padc.utilites.EM_NULL_RESPONSE

class DetailPresenter: BasePresenter<DetailView>() {

    fun onUiReady(fragment: BaseFragment, id: Int) {
        if (id != null) {
            model.getMovieDetail(id, {
                mView.displayMovieDetail(it)
            }, {
                mView.errorMessage(it)
            })
        }

        model.getSimilarMovies(id, {
            mView.displaySimilarMovies(it)
        }, {
            mView.errorMessage(it)
        })
    }

    fun playTrailer(videoId: String){
        if(videoId.isNullOrEmpty()){
            mView.errorMessage(EM_NULL_RESPONSE)
        }
        else{
            mView.showTrailers()
        }
    }
}