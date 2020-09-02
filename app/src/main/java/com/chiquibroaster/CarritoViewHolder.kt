package com.chiquibroaster

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.chiquibroaster.ui.carrito.CarritoFragmentDirections

class CarritoViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_carrito, parent, false)){


    private var cantPechos      : Int? = 0
    private var cantPiernas     : Int? = 0
    private var coca2l          : Int? = 0
    private var cocazero2l      : Int? = 0
    private var sprite2l        : Int? = 0
    private var fantanaranja2l  : Int? = 0
    private var fantamand2l     : Int? = 0
    private var fantapapaya2l   : Int? = 0
    private var fantapina2l     : Int? = 0
    private var fantaguarana2l  : Int? = 0
    private var mineragua2l     : Int? = 0
    private var coca500         : Int? = 0
    private var cocazero500     : Int? = 0
    private var sprite500       : Int? = 0
    private var fanta500        : Int? = 0
    private var agua500         : Int? = 0
    //private var nombreFac       : String? = null
    //private var nitFac          : String? = null
    //private var referencia      : String? = null
    //private var latitud         : String? = null
    //private var longitud        : String? = null
    private var arroz           : Int? = 0
    private var papa            : Int? = 0
    private var platano         : Int? = 0
    private var seguimiento     : Button? = null
    private var recibi          : Button? = null


    private var estPed          : TextView? = null
    //private var horaPed         : String? = null
    //private var fechaPed        : String? = null
    private var cantT           :Int? = 0

    private var prodFinal       : TextView? = null
    private var cantTot         : TextView? = null
    private var totalComplete   : TextView? = null


    init{

        prodFinal = itemView.findViewById(R.id.prodCarTextView)
        totalComplete = itemView.findViewById(R.id.totCarTextView)
        estPed = itemView.findViewById(R.id.stateCarTextView)
        seguimiento = itemView.findViewById(R.id.seguimientoButton)
        recibi = itemView.findViewById(R.id.recibiButton)


    }

    @SuppressLint("SetTextI18n")
    fun bind(dat: DatosCarrito){

        cantPechos = if(dat.cantPechos==null){
            0
        }else{
            dat.cantPechos.toInt()
        }
//
        cantPiernas = if(dat.cantPiernas==null){
            0
        }else{
            dat.cantPiernas.toInt()
        }
////
        arroz = if(dat.arroz==null){
            0
        }else{
            dat.arroz.toInt()
        }
////
        papa = if(dat.papa==null){
            0
        }else{
            dat.papa.toInt()
        }
////
        platano = if(dat.platano==null){
            0
        }else{
            dat.platano.toInt()
        }
//
        prodFinal?.text = dat.producto1
//
        coca2l = if(dat.coca2l.toString()=="null"){
            0
        }else{
            dat.coca2l!!.toInt()
        }
        cocazero2l = if(dat.cocazero2l.toString()=="null"){
            0
        }else{
            dat.cocazero2l!!.toInt()
        }
        sprite2l = if(dat.sprite2l.toString()=="null"){
            0
        }else{
            dat.sprite2l!!.toInt()
        }
        fantanaranja2l = if(dat.fantanaranja2l.toString()=="null"){
            0
        }else{
            dat.fantanaranja2l!!.toInt()
        }
        fantamand2l = if(dat.fantamand2l.toString()=="null"){
            0
        }else{
            dat.fantamand2l!!.toInt()
        }
        fantapapaya2l = if(dat.fantapapaya2l.toString()=="null"){
            0
        }else{
            dat.fantapapaya2l!!.toInt()
        }
        fantapina2l = if(dat.fantapina2l.toString()=="null"){
            0
        }else{
            dat.fantapina2l!!.toInt()
        }
        fantaguarana2l = if(dat.fantaguarana2l.toString()=="null"){
            0
        }else{
            dat.fantaguarana2l!!.toInt()
        }
        mineragua2l = if(dat.mineragua2l.toString()=="null"){
            0
        }else{
            dat.mineragua2l!!.toInt()
        }
        coca500 = if(dat.coca500.toString()=="null"){
            0
        }else{
            dat.coca500!!.toInt()
        }
        cocazero500 = if(dat.cocazero500.toString()=="null"){
            0
        }else{
            dat.cocazero500!!.toInt()
        }
        sprite500 = if(dat.sprite500.toString()=="null"){
            0
        }else{
            dat.sprite500!!.toInt()
        }
        fanta500 = if(dat.fanta500.toString()=="null"){
            0
        }else{
            dat.fanta500!!.toInt()
        }
        agua500 = if(dat.agua500.toString()=="null"){
            0
        }else{
            dat.agua500!!.toInt()
        }



        cantT = cantPechos!! + cantPiernas!! + coca2l!! + cocazero2l!! + sprite2l!! + fantanaranja2l!! + fantamand2l!! + fantapapaya2l!! + fantapina2l!! + fantaguarana2l!! + mineragua2l!! + coca500!! + cocazero500!! + sprite500!! + fanta500!! + agua500!! + arroz!! + papa!! + platano!!
//
        cantTot?.text = cantT.toString()
//
        totalComplete?.text = "${dat.total} Bs."

        estPed?.text = dat.estPed
//
        if(estPed?.text=="ENTREGADO"){
            seguimiento?.isVisible = false
            recibi?.isVisible = false
        }
        if(estPed?.text == "PENDIENTE"){
            seguimiento?.isVisible = false
            recibi?.isVisible = false
        }
        if(estPed?.text=="ENVIADO"){
            seguimiento?.isVisible = true
            recibi?.isVisible = true
//
            seguimiento?.setOnClickListener{
                val action = CarritoFragmentDirections.actionCarritoFragmentToSeguimientoFragment(dat.latDel.toString(), dat.londel.toString(), prodFinal!!.text.toString(), dat.total.toString(), dat.estPed.toString(), dat.horaPed.toString(), dat.idDel.toString(), dat.idPed.toString())
                it.findNavController().navigate(action)
            }
            recibi?.setOnClickListener {
                val action = CarritoFragmentDirections.actionFinal(dat.idPed.toString(), dat.idDel.toString())
                it.findNavController().navigate(action)
            }


        }




    }
}
