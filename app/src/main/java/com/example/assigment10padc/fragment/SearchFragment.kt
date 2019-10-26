package com.example.assigment10padc.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assigment10padc.MainActivity
import com.example.assigment10padc.R
import com.example.assigment10padc.adapter.MovieListAdapter
import com.example.assigment10padc.data.models.MoviModelImpl
import com.example.assigment10padc.data.models.MovieModel
import com.example.assigment10padc.data.vos.MovieVO
import com.example.assigment10padc.mvp.presenter.MainPresenter
import com.example.assigment10padc.mvp.presenter.MovieSearchPresenter
import com.example.assigment10padc.mvp.views.MovieSearchView
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment(), MovieSearchView {

    override fun displayMovies(movies: List<MovieVO>) {
        nowPlayingItemAdapter.setNewData(movies.toMutableList())
    }

    override fun errorMessage(message: String) {
        errorMessage(message)
    }

    private lateinit var movieSearchPresenter: MovieSearchPresenter
    private lateinit var mainPresenter: MainPresenter
    private lateinit var nowPlayingItemAdapter: MovieListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.fragment_search, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieSearchPresenter = ViewModelProviders.of(this).get(MovieSearchPresenter::class.java)
        movieSearchPresenter.initPresenter(this)

        nowPlayingItemAdapter = MovieListAdapter(mainPresenter)
        with(rvSearchResult){
            layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 3)
            adapter = nowPlayingItemAdapter
        }

        searchView.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val search_keyword = searchView.text.toString()
                return@OnEditorActionListener true
            }
            false
        })

        searchView.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                movieSearchPresenter.onUiReady(this)
            }
            false
        }

        searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                searchByKeyword(s.toString())
            }
        })



        movieSearchPresenter.onUiReady(this)
    }

    fun searchByKeyword(keyword: String){
        val model: MovieModel = MoviModelImpl
        nowPlayingItemAdapter.setNewData(model.getSearchMovie(keyword) as MutableList<MovieVO>)
        rvSearchResult.adapter = nowPlayingItemAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity = context as MainActivity
        mainPresenter = activity.getPresenter()
    }
}