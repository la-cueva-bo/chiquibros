package com.chiquibroaster.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CuartoAdaptador: RecyclerView.Adapter<CuartoViewHolder>() {

    private var dataList= mutableListOf<Base>()
    fun setListData(data:MutableList<Base>) {

        dataList=data

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuartoViewHolder {

        val inflater= LayoutInflater.from(parent.context)
        return CuartoViewHolder(
            inflater,
            parent
        )


    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CuartoViewHolder, position: Int) {
        val cuarto: Base =dataList[position]
        holder.bind(cuarto)
    }


}
