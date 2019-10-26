package com.example.assigment10padc.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import coil.api.load
import com.example.assigment10padc.MainActivity
import com.example.assigment10padc.R
import com.example.assigment10padc.adapter.MovieListAdapter
import com.example.assigment10padc.data.vos.MovieDetailVO
import com.example.assigment10padc.data.vos.MovieVO
import com.example.assigment10padc.mvp.presenter.DetailPresenter
import com.example.assigment10padc.mvp.presenter.MainPresenter
import com.example.assigment10padc.mvp.views.DetailView
import com.example.assigment10padc.utilites.IMAGE_PATH
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.youtube_player.view.*

class DetailFragment: BaseFragment(), DetailView {

    private var videoId: String? = ""

    override fun showTrailers() {
        showTrailers(videoId!!)
    }

    private lateinit var mainPresenter: MainPresenter
    private lateinit var movieDetailPresenter: DetailPresenter

    private lateinit var movieAdapter: MovieListAdapter

    companion object{

        const val EXTRA_MOVIE_ID = "movieId"

        fun newFragment(movieId: Int): Fragment {
            val bundle = Bundle()
            bundle.putInt(EXTRA_MOVIE_ID, movieId)

            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieDetailPresenter = ViewModelProviders.of(this).get(DetailPresenter::class.java)
        movieDetailPresenter.initPresenter(this)

        movieAdapter = MovieListAdapter(mainPresenter)

        val id = this.arguments!!.getInt(EXTRA_MOVIE_ID, 0)

        movieAdapter = MovieListAdapter(mainPresenter)
        with(view.rvDetailMovies){
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context, androidx.recyclerview.widget.RecyclerView.HORIZONTAL, false)
            adapter = movieAdapter
        }

        view.img_close.setOnClickListener {

        }

        view.btn_play.setOnClickListener {
            movieDetailPresenter.playTrailer(videoId!!)
        }

        movieDetailPresenter.onUiReady(this, id)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity = context as MainActivity
        mainPresenter = activity.getPresenter()
    }

    override fun displayMovieDetail(data: MovieDetailVO) {
        bindData(data)
    }

    override fun displaySimilarMovies(movies: List<MovieVO>) {
        movieAdapter.setNewData(movies.toMutableList())
    }

    override fun errorMessage(errorMessage: String) {
        errorMessage(errorMessage)
    }

    fun bindData(data: MovieDetailVO){
     //   view!!.imgPoster.load(IMAGE_PATH + data.posterPath)
        view!!.txt_release_date.text = data.releaseDate
        view!!.textView15.text = data.runTime.toString() + " min"
        view!!.txt_detail_descript.text = data.overview
    }

    fun showTrailers(videoId: String) {

    }
}