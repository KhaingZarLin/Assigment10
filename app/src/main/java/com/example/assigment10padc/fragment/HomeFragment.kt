package com.example.assigment10padc.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.assigment10padc.MainActivity

import com.example.assigment10padc.R
import com.example.assigment10padc.adapter.MovieListAdapter
import com.example.assigment10padc.data.vos.MovieVO
import com.example.assigment10padc.mvp.presenter.MainPresenter
import com.example.assigment10padc.mvp.presenter.MoviePresenter
import com.example.assigment10padc.mvp.views.MovieView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), MovieView {

    override fun showTopRatedMovie(movies: List<MovieVO>) {
        topRatedItemAdapter.setNewData(movies.toMutableList())
    }

    override fun showPopularMovie(movies: List<MovieVO>) {
        popularItemAdapter.setNewData(movies.toMutableList())
    }

    override fun showUpcomingMovie(movies: List<MovieVO>) {
        upComingItemAdapter.setNewData(movies.toMutableList())
    }

    override fun showNowPlayingMovie(movies: List<MovieVO>) {
        nowPlayingItemAdapter.setNewData(movies.toMutableList())
    }

    override fun errorMessage(errorMessage: String) {
        errorMessage(errorMessage)
    }

    private lateinit var mainPresenter: MainPresenter
    private lateinit var movieListPresenter: MoviePresenter

    private lateinit var nowPlayingItemAdapter: MovieListAdapter
    private lateinit var popularItemAdapter: MovieListAdapter
    private lateinit var topRatedItemAdapter: MovieListAdapter
    private lateinit var upComingItemAdapter: MovieListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parentActivity = context as MainActivity
        mainPresenter = parentActivity.getPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.fragment_home, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListPresenter = ViewModelProviders.of(this).get(MoviePresenter::class.java)
        movieListPresenter.initPresenter(this)

        nowPlayingItemAdapter = MovieListAdapter(mainPresenter)
        with(rcMovieListHome) {
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.RecyclerView.HORIZONTAL,
                false
            )
            adapter = nowPlayingItemAdapter
        }

        popularItemAdapter = MovieListAdapter(mainPresenter)
        with(rc_popular){
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.RecyclerView.HORIZONTAL,
                false
            )
            adapter = popularItemAdapter
        }

        topRatedItemAdapter = MovieListAdapter(mainPresenter)
        with(rc_rate){
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.RecyclerView.HORIZONTAL,
                false
            )
            adapter = topRatedItemAdapter
        }

        upComingItemAdapter = MovieListAdapter(mainPresenter)
        with(rc_upcoming){
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.RecyclerView.HORIZONTAL,
                false
            )
            adapter = upComingItemAdapter
        }

        movieListPresenter.onUiReady(this)
    }

}
