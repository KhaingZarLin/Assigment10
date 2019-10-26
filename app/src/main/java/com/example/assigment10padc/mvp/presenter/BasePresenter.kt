package com.example.assigment10padc.mvp.presenter

import androidx.lifecycle.ViewModel
import com.example.assigment10padc.data.models.MoviModelImpl
import com.example.assigment10padc.mvp.views.BaseView

abstract class BasePresenter<T: BaseView>: ViewModel(){

    protected val model = MoviModelImpl

    protected lateinit var mView: T

    open fun initPresenter(view: T) {
        mView = view
    }
}