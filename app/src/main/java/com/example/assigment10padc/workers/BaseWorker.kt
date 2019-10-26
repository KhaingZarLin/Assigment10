package com.example.assigment10padc.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.assigment10padc.networks.datagents.MovieDataAgents
import com.example.assigment10padc.networks.datagents.RetrofitDataAgents
import com.example.assigment10padc.persistences.MovieDataBase

abstract class BaseWorker(context: Context, workerParams: WorkerParameters):
    Worker(context, workerParams)
{
    protected val dataAgent: MovieDataAgents = RetrofitDataAgents

    protected val movieDB = MovieDataBase.getInstance(context)

}
