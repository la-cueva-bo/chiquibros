package com.chiquibroaster.ui.carrito

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chiquibroaster.DatosCarrito

class CarritoViewModel: ViewModel() {

    private val repoCarrito = RepoCarrito()
    fun fetchData(): LiveData<MutableList<DatosCarrito>> {
        val mutableData= MutableLiveData<MutableList<DatosCarrito>>()
        repoCarrito.getData().observeForever{
            mutableData.value = it
        }
        return mutableData
    }

}
