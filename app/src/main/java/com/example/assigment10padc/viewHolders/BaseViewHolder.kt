package com.example.assigment10padc.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView){

    var data :T? = null
        set(value) {
            field = value
            if(value!= null) bindData(value)
        }

    abstract fun bindData(data:T)

}