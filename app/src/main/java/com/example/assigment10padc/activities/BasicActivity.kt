package com.example.assigment10padc.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assigment10padc.R
import com.example.assigment10padc.data.models.MoviModelImpl
import com.example.assigment10padc.data.models.MovieModel

abstract class BasicActivity : AppCompatActivity() {

    protected lateinit var model: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        model = MoviModelImpl
    }

}
