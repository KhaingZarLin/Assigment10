package com.example.assigment10padc.data.models

import android.content.Context
import com.example.assigment10padc.networks.datagents.MovieDataAgents
import com.example.assigment10padc.networks.datagents.RetrofitDataAgents
import com.example.assigment10padc.persistences.MovieDataBase

abstract class BaseModel {
    protected val dataAgent:MovieDataAgents = RetrofitDataAgents

    protected lateinit var database: MovieDataBase

    fun initDatabase(context: Context){
        database = MovieDataBase.getInstance(context)
    }
}