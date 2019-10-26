package com.example.assigment10padc

import android.app.Application
import androidx.work.*
import com.example.assigment10padc.data.models.MoviModelImpl
import com.example.assigment10padc.workers.*
import java.util.concurrent.TimeUnit

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MoviModelImpl.initDatabase(applicationContext)

        getNowPlayingOneTime()
        getPopularOneTime()
        getTopRatedOneTime()
        getUpcomingOneTime()
        getNowPlayingPeriodically()
        getPopularPeriodically()
        getTopRatedPeriodically()
        getUpcomingPeriodically()
    }
    private fun getNowPlayingOneTime() {
        val getNowPlayingMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetNowPlayingMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getNowPlayingMoviesWorkRequest)
    }
    private fun getTopRatedOneTime() {
        val getTopRatedMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetTopRatedMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesWorkRequest)
    }
    private fun getPopularOneTime() {
        val getPopularMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetPopularMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesWorkRequest)
    }
    private fun getUpcomingOneTime() {
        val getUpComingMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetUpcomingMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getUpComingMoviesWorkRequest)
    }

    private fun getNowPlayingPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getNowShowingMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetNowPlayingMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getNowShowingMoviesWorkRequest)
    }
    private fun getTopRatedPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getTopRatedMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetTopRatedMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesWorkRequest)
    }
    private fun getPopularPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getPopularMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetPopularMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesWorkRequest)
    }
    private fun getUpcomingPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getUpComingMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetUpcomingMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getUpComingMoviesWorkRequest)
    }
}