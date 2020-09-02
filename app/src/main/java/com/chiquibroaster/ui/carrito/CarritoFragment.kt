package com.chiquibroaster.ui.carrito

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
import com.chiquibroaster.AdapterCarrito
import com.chiquibroaster.R

class CarritoFragment : Fragment() {

    private val carritoViewModel: CarritoViewModel by lazy {
        ViewModelProvider(this).get(CarritoViewModel::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_slideshow, container, false)

        val recy1 = view.findViewById<RecyclerView>(R.id.recyclerCarrito)

        val adapter = AdapterCarrito()

        recy1.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recy1.adapter = adapter

        carritoViewModel.fetchData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })

        return view
    }
}