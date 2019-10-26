package com.example.assigment10padc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.assigment10padc.data.models.MoviModelImpl
import com.example.assigment10padc.data.models.MovieModel

abstract class BaseFragment: Fragment() {

    private lateinit var model: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = MoviModelImpl
    }
}