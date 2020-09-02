package com.chiquibroaster

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class RepoPedidos {
    fun getData(): LiveData<MutableList<DatosCarrito>>{
        val mutableData = MutableLiveData<MutableList<DatosCarrito>>()

        val string = AppChiqui.context.resources.getString(R.string.prefs_file)
        val prefs = AppChiqui.context.getSharedPreferences(string, Context.MODE_PRIVATE)
        val userId = prefs.getString("userId", "")
        val user = prefs.getString("user", "")

        val db = FirebaseFirestore.getInstance().collection("Pedidos")
        db.get().addOnCompleteListener{
            if(it.isSuccessful){
                val listData = mutableListOf<DatosCarrito>()
                for(documentos in it.result!!){
                    val nombre = documentos.getString("userNombre")
                    val idUser = documentos.getString("usuarioId")
                    if(nombre==user&&idUser==userId){
                            val estado = documentos.getString("estadoPedido")
                            val producto1 = documentos.getString("Producto")
                            val cantPechos = documentos.getString("cantidadpechos")
                            val cantPiernas = documentos.getString("cantidadpiernas")
                            val coca2l = documentos.getString("coca_cola_2l")
                            val cocazero2l = documentos.getString("coca_cola_zero_2l")
                            val sprite2l = documentos.getString("sprite_2l")
                            val fantanaranja2l = documentos.getString("fanta_naranja_2l")
                            val fantamand2l = documentos.getString("fanta_mandarina_2l")
                            val fantapapaya2l = documentos.getString("fanta_papaya_2l")
                            val fantapina2l = documentos.getString("fanta_piña_2l")
                            val fantaguarana2l = documentos.getString("fanta_guarana_2l")
                            val mineragua2l = documentos.getString("mineragua_2l")
                            val coca500 = documentos.getString("coca_cola_500ml")
                            val cocazero500 = documentos.getString("coca_zero_500ml")
                            val sprite500 = documentos.getString("sprite_500ml")
                            val fanta500 = documentos.getString("fanta_naranja_500ml")
                            val agua500 = documentos.getString("agua_500ml")
                            val nombreFac = documentos.getString("nombreFactura")
                            val nitFac = documentos.getString("nit")
                            val referencia = documentos.getString("ubicacion")
                            val latitud = documentos.getString("latitud")
                            val longitud = documentos.getString("longitud")
                            val arroz = documentos.getString("arrozExtra")
                            val papa = documentos.getString("papaExtra")
                            val platano = documentos.getString("platanoExtra")
                            val idPed = documentos.id
                            val horaPed = documentos.getString("hora_ped")
                            val fechaPed = documentos.getString("fecha_pedido")
                            val total = documentos.getString("total")
//
                            val datos = DatosCarrito(producto1, cantPechos, cantPiernas, coca2l, cocazero2l, sprite2l, fantanaranja2l, fantamand2l, fantapapaya2l, fantapina2l, fantaguarana2l, mineragua2l, coca500, cocazero500, sprite500, fanta500, agua500, nombreFac, nitFac, referencia, latitud, longitud, arroz, papa, platano, idPed, estado, horaPed, fechaPed, total)
                            listData.add(datos)
//


                    }
                }
                mutableData.value = listData
            }
        }



        return mutableData
    }

}
