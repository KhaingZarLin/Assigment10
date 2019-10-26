package com.example.assigment10padc.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.assigment10padc.viewHolders.BaseViewHolder

abstract class BaseRecyclerAdapter<VH : BaseViewHolder<T>, T> : RecyclerView.Adapter<VH>() {

   private var data: MutableList<T> = ArrayList()

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data = data[position]
    }

    fun setNewData(newData:MutableList<T>){
        data = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: MutableList<T>){
        data.addAll(newData)
        notifyDataSetChanged()
    }

}