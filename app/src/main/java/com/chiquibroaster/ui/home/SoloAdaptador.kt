package com.chiquibroaster.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SoloAdaptador: RecyclerView.Adapter<SoloViewHolder>() {

    private var dataList= mutableListOf<Base>()
    fun setListData(data:MutableList<Base>) {

        dataList=data

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoloViewHolder {

        val inflater= LayoutInflater.from(parent.context)
        return SoloViewHolder(
            inflater,
            parent
        )


    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: SoloViewHolder, position: Int) {
        val solo: Base =dataList[position]
        holder.bind(solo)
    }


}
