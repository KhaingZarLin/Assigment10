package com.example.assigment10padc.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.assigment10padc.data.vos.*

object MoviModelImpl : BaseModel(), MovieModel {

    override fun getAllMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(database.movieDao().getMovies())
    }

    override fun getSearchMovie(title: String): List<MovieVO> {
        return database.movieDao().getSearchMovie("%$title%")
    }

    override fun getMovieDetail(
        id: Int,
        onSuccess: (MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        dataAgent.getMovieDetail(id,
            onSuccess= {
                onSuccess(it)
            },
            onFailure= {
                onFailure(it)
            })
    }

    override fun getUpComingMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(database.movieDao().getUpcomingMovies())
    }

    override fun getPopularMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(database.movieDao().getPopularMovies())
    }

    override fun getTopRatedMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(database.movieDao().getTopRatedMovies())
    }

    override fun getSimilarMovies(
        id: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        dataAgent.getSimilarMovies(id,
            onSuccess= {
                onSuccess(it)
            },
            onFailure= {
                onFailure(it)
            })
    }

    override fun getNowPlayingMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(database.movieDao().getNowPlayngMovies())
    }

}




