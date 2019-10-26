package com.example.assigment10padc.viewHolders

import android.view.View
import coil.api.load
import com.example.assigment10padc.data.vos.MovieVO
import com.example.assigment10padc.delegates.MovieDelegate
import com.example.assigment10padc.utilites.IMAGE_PATH
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieListViewHolder(itemView: View, private val delegate: MovieDelegate): BaseViewHolder<MovieVO>(itemView) {

    init {
        itemView.itemMovieImage.setOnClickListener {
            data?.id?.let {id ->
                delegate.onTabEventItem(id)
            }
        }
    }

    override fun bindData(movie: MovieVO) {
//        itemView.itemMovieImage.load(IMAGE_PATH+movie.posterImage)
        itemView.itemMovieImage.load(IMAGE_PATH+movie.posterImage)
    }

}