package com.example.assigment10padc

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.assigment10padc.activities.BasicActivity
import com.example.assigment10padc.fragment.*
import com.example.assigment10padc.mvp.presenter.MainPresenter
import com.example.assigment10padc.mvp.presenter.MoviePresenter
import com.example.assigment10padc.mvp.views.MainView
import com.example.assigment10padc.mvp.views.MovieView
import com.example.assignment_9.fragments.MoreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasicActivity(), MainView {
    override fun navigateToMovieDetail(id: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentcontainer, DetailFragment.newFragment(id))
            .commit()
    }

    fun getPresenter(): MainPresenter {
        return mPresenter

    }

    private lateinit var mPresenter: MainPresenter

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home-> goToFragment(HomeFragment())

                R.id.search -> goToFragment(SearchFragment())

                R.id.comingsoon-> goToFragment(ComingSoonFragment())

                R.id.download -> goToFragment(DownloadFragment())

                R.id.more -> goToFragment(MoreFragment())
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mPresenter.initPresenter(this)

        btn_nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        goToFragment(HomeFragment())

    }

    private fun goToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentcontainer, fragment)
            .commit()
    }
}
