package com.chiquibroaster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PedidosViewModel: ViewModel() {

    private val repoPedidos = RepoPedidos()
    fun fetchData(): LiveData<MutableList<DatosCarrito>> {
        val mutableData= MutableLiveData<MutableList<DatosCarrito>>()
        repoPedidos.getData().observeForever{
            mutableData.value = it
        }
        return mutableData
    }

}
