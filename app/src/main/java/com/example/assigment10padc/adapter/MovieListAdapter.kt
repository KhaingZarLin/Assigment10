package com.example.assigment10padc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.assigment10padc.R
import com.example.assigment10padc.data.vos.MovieVO
import com.example.assigment10padc.delegates.MovieDelegate
import com.example.assigment10padc.viewHolders.MovieListViewHolder

class MovieListAdapter(private val delegate: MovieDelegate): BaseRecyclerAdapter<MovieListViewHolder, MovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieListViewHolder(itemView, delegate)
    }
}