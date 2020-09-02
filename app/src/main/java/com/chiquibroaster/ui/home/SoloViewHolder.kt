package com.chiquibroaster.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isInvisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chiquibroaster.AppChiqui
import com.chiquibroaster.R

class SoloViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_pollo,parent,false)) {


    private var imagesolo: ImageView? = null
    private var titulosolo: TextView? = null
    private var presassolo: TextView? = null
    private var tituloguarniciones: TextView? = null
    private var arroz: TextView? = null
    private var papas: TextView? = null
    private var platano: TextView? = null
    private var aderezos: TextView? = null
    private var card: CardView? = null
    private val preciosolo: Int? = 15


    init {
        imagesolo = itemView.findViewById(R.id.imageitempollo)
        titulosolo = itemView.findViewById(R.id.nomreTextView)
        presassolo = itemView.findViewById(R.id.textView4)
        tituloguarniciones = itemView.findViewById(R.id.textguar)
        arroz = itemView.findViewById(R.id.textitemarroz)
        papas = itemView.findViewById(R.id.textitempapas)
        platano = itemView.findViewById(R.id.textitemplatano)
        aderezos = itemView.findViewById(R.id.textitemaderezos)
        card = itemView.findViewById(R.id.carditempollo)
    }

    @SuppressLint("SetTextI18n")
    fun bind(solo: Base) {
        imagesolo?.let {
            Glide.with(AppChiqui.context).load(solo.imageCuarto).into(imagesolo!!)

        }
        titulosolo?.text = "Solo Pollo"
        presassolo?.text = "Presas:" + solo.pres1Cuarto + " " + "-" + " " + solo.presa2Cuarto
        tituloguarniciones?.text = "Sin Guarniciones"
        arroz?.text = "-Aderezos"
        papas?.isInvisible = true
        platano?.isInvisible = true
        aderezos?.isInvisible = true

        card?.setOnClickListener {

            val flecha =
                HomeFragmentDirections.nextAction(
                    "Solo Pollo", "", "", "", solo.imageCuarto.toString(), solo.imAr.toString(),
                    solo.imPa.toString(),
                    solo.imPl.toString(),
                    solo.impre.toString(),
                    preciosolo.toString()
                )
            it.findNavController().navigate(flecha)
        }


    }
}
