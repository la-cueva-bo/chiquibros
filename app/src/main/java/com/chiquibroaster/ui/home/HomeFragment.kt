package com.chiquibroaster.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chiquibroaster.R

class HomeFragment : Fragment() {

    private val homeviewmodel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java) }

    private val homeViewModelSolo:HomeViewModelSolo by lazy{
        ViewModelProvider(this).get(HomeViewModelSolo::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerCuarto = root.findViewById<RecyclerView>(R.id.cuartoPollo)
        val recyclerSolo = root.findViewById<RecyclerView>(R.id.solo)

        val adaptador=
            CuartoAdaptador()
        val adaptadorsolo=
            SoloAdaptador()




        recyclerCuarto.layoutManager=
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        recyclerCuarto.adapter=adaptador


        recyclerSolo.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        recyclerSolo.adapter=adaptadorsolo


        homeviewmodel.fetchDatosPolloData().observe(viewLifecycleOwner, Observer {
            adaptador.setListData(it)
            adaptador.notifyDataSetChanged()
        })
        homeViewModelSolo.DatosPolloData().observe(viewLifecycleOwner, Observer {
            adaptadorsolo.setListData(it)
            adaptadorsolo.notifyDataSetChanged()
        })

        return root
    }
}