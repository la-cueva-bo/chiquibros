package com.chiquibroaster.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class RepositoriosSolo {

    fun getDatosPolloData():LiveData<MutableList<Base>>{
        val listaVariable = MutableLiveData<MutableList<Base>>()

        val db = FirebaseFirestore.getInstance().collection("Productos")
        val cuartRef = db.document("Cuarto_de_pollo")
        cuartRef.get().addOnSuccessListener { documentSnapshot ->
            val listaData = mutableListOf<Base>()
            val imagen1 = documentSnapshot.getString("imgsolopecho")
            val presa1 = documentSnapshot.getString("CPPA")
            val imagen2 = documentSnapshot.getString("imgsolopierna")
            val presa2 = documentSnapshot.getString("CPPE")

            db.document("Guarniciones").get().addOnSuccessListener { document->
                val gua1 = document.getString("G1")
                val gua2 = document.getString("G2")
                val gua3 = document.getString("G3")
                val imAr = document.getString("imgarroz")
                val imgPa = document.getString("imgpapa")
                val imgpl = document.getString("imgplatano")
                val datoscuarto1 = Base(imagen1,presa1, presa2, imagen2, gua1, gua2, gua3, imAr, imgPa, imgpl)
                listaData.add(datoscuarto1)
                listaVariable.value = listaData
            }

        }




        return listaVariable

    }

}
