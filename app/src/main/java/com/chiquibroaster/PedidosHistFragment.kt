package com.chiquibroaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PedidosHistFragment : Fragment() {

    private val pedidosViewModel: PedidosViewModel by lazy {
        ViewModelProvider(this).get(PedidosViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pedidos_hist, container, false)

        val recy1 = view.findViewById<RecyclerView>(R.id.recyclerPedidos)

        val adapter = AdapterCarrito()

        recy1.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recy1.adapter = adapter

        pedidosViewModel.fetchData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })

        return view
    }


}