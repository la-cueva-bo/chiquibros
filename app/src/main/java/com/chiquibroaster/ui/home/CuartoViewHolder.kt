package com.chiquibroaster.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chiquibroaster.AppChiqui
import com.chiquibroaster.R

class CuartoViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_pollo,parent,false)) {
    private var imageCuarto: ImageView?=null
    private var tituloCuarto: TextView?=null
    private var presascuarto: TextView?= null
    private var tituloguarniciones: TextView?=null
    private var arroz: TextView?=null
    private var papas: TextView?=null
    private var platano: TextView?= null
    private var aderezos: TextView?= null
    private  var card: CardView?= null
    private val preciocuarto:Int? = 28




    init {
        imageCuarto=itemView.findViewById(R.id.imageitempollo)
        tituloCuarto=itemView.findViewById(R.id.nomreTextView)
        presascuarto=itemView.findViewById(R.id.textView4)
        tituloguarniciones=itemView.findViewById(R.id.textguar)
        arroz=itemView.findViewById(R.id.textitemarroz)
        papas=itemView.findViewById(R.id.textitempapas)
        platano=itemView.findViewById(R.id.textitemplatano)
        aderezos=itemView.findViewById(R.id.textitemaderezos)
        card=itemView.findViewById(R.id.carditempollo)
    }

    @SuppressLint("SetTextI18n")
    fun bind(cuarto: Base){
        imageCuarto?.let{
            Glide.with(AppChiqui.context).load(cuarto.imageCuarto).into(imageCuarto!!)

        }
        tituloCuarto?.text="Cuarto de Pollo"
        presascuarto?.text="Presas:" + cuarto.pres1Cuarto + " "+"-"+" "+cuarto.presa2Cuarto
        tituloguarniciones?.text = "Guarniciones:"
        arroz?.text="-${cuarto.arroz}"
        papas?.text="-${cuarto.papas}"
        platano?.text="-${cuarto.platano}"
        aderezos?.text="-Aderezos"
        card?.setOnClickListener{




            val flecha =
                HomeFragmentDirections.nextAction(
                    "Cuarto de Pollo",
                    cuarto.arroz.toString(),
                    cuarto.papas.toString(),
                    cuarto.platano.toString(),
                    cuarto.imageCuarto.toString(),
                    cuarto.imAr.toString(),
                    cuarto.imPa.toString(),
                    cuarto.imPl.toString(),
                    cuarto.impre.toString(),
                    preciocuarto.toString()

                )
            it.findNavController().navigate(flecha)


        }

    }





}
