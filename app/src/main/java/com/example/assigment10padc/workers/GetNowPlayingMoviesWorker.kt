package com.example.assigment10padc.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetNowPlayingMoviesWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        dataAgent.getNowPlayingMovies(page = 1,
            onSuccess = {
                movieDB.movieDao().insertMovies(it)
                result = Result.success()
            }, onFailure = {
                result = Result.failure()
            }
        )
        return result
    }

}