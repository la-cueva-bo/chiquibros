package com.chiquibroaster.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val repositorios = Repositorios()
    fun fetchDatosPolloData(): LiveData<MutableList<Base>> {
        val mutantelista = MutableLiveData<MutableList<Base>>()
        repositorios.getDatosPolloData().observeForever {
            mutantelista.value = it
        }




        return mutantelista

    }
}