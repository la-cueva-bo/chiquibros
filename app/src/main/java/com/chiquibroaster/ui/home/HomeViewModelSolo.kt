package com.chiquibroaster.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModelSolo: ViewModel(){

    private val repositoriosSolo = RepositoriosSolo()
    fun DatosPolloData(): LiveData<MutableList<Base>> {
        val mutantelista = MutableLiveData<MutableList<Base>>()
        repositoriosSolo.getDatosPolloData().observeForever{
            mutantelista.value = it
        }
        return mutantelista

    }




}
