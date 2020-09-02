package com.chiquibroaster

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_refrescos500ml.*


class Refrescos500mlFragment : Fragment() {

    private var contador: Int? = 0
    private var contador1: Int? = 0
    private var contador2: Int? = 0
    private var contador3: Int? = 0
    private var contador4: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_refrescos500ml, container, false)

        val confirefresco=view.findViewById<Button>(R.id.confi500ml)
        val botoncoca1 = view.findViewById<ImageButton>(R.id.coca5001)
        val botoncoca2 = view.findViewById<ImageButton>(R.id.coca5002)
        val botoncocaz1 = view.findViewById<ImageButton>(R.id.cocaz5001)
        val botoncocaz2 = view.findViewById<ImageButton>(R.id.cocaz5002)
        val botonsprite1 = view.findViewById<ImageButton>(R.id.sprite5001)
        val botonsprite2 = view.findViewById<ImageButton>(R.id.sprite5002)
        val botonfantan1 = view.findViewById<ImageButton>(R.id.fanta5001)
        val botonfantan2 = view.findViewById<ImageButton>(R.id.fanta5002)
        val botonagua1 = view.findViewById<ImageButton>(R.id.agua1)
        val botonagua2 = view.findViewById<ImageButton>(R.id.agua2)

        val textcoca500 = view.findViewById<TextView>(R.id.textcoca500)
        val textcocaz500 = view.findViewById<TextView>(R.id.textcocaz500)
        val textsprite500 = view.findViewById<TextView>(R.id.textsprite500)
        val textfantan500 = view.findViewById<TextView>(R.id.textfanta500)
        val textagua500 = view.findViewById<TextView>(R.id.textagua500)



        botoncoca2.isEnabled = false
        botoncoca1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador!! + co!!)
            contador = suma
            if(contador != 0){
                botoncoca2.isEnabled = true
            }
            textcoca500.text = suma.toString()
        }
        botoncoca2.setOnClickListener{
            val co:Int?=1
            val resta = (contador!!-co!!)
            contador=resta
            if(contador == 0){
                botoncoca2.isEnabled = false
            }
            textcoca500.text=resta.toString()
        }

        botoncocaz2.isEnabled = false
        botoncocaz1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador1!! + co!!)
            contador1 = suma
            if(contador1 != 0){
                botoncocaz2.isEnabled = true
            }
            textcocaz500.text = suma.toString()
        }
        botoncocaz2.setOnClickListener{
            val co:Int?=1
            val resta = (contador1!!-co!!)
            contador1=resta
            if(contador1 == 0){
                botoncocaz2.isEnabled = false
            }
            textcocaz500.text=resta.toString()
        }

        botonsprite2.isEnabled = false
        botonsprite1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador2!! + co!!)
            contador2 = suma
            if(contador2 != 0){
                botonsprite2.isEnabled = true
            }
            textsprite500.text = suma.toString()
        }
        botonsprite2.setOnClickListener{
            val co:Int?=1
            val resta = (contador2!!-co!!)
            contador2=resta
            if(contador2 == 0){
                botonsprite2.isEnabled = false
            }
            textsprite500.text=resta.toString()
        }

        botonfantan2.isEnabled = false
        botonfantan1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador3!! + co!!)
            contador3 = suma
            if(contador3 != 0){
                botonfantan2.isEnabled = true
            }
            textfanta500.text = suma.toString()
        }
        botonfantan2.setOnClickListener{
            val co:Int?=1
            val resta = (contador3!!-co!!)
            contador3=resta
            if(contador3 == 0){
                botonfantan2.isEnabled = false
            }
            textfanta500.text=resta.toString()
        }

        botonagua2.isEnabled = false
        botonagua1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador4!! + co!!)
            contador4 = suma
            if(contador4 != 0){
                botonagua2.isEnabled = true
            }
            textagua500.text = suma.toString()
        }
        botonagua2.setOnClickListener{
            val co:Int?=1
            val resta = (contador4!!-co!!)
            contador4=resta
            if(contador4 == 0){
                botonagua2.isEnabled = false
            }
            textagua500.text=resta.toString()
        }


        confirefresco.setOnClickListener {

            val cancoca500 = textcoca500.text
            val cancocaz500 = textcocaz500.text
            val cansprite500 = textsprite500.text
            val canfantan500 = textfantan500.text
            val canagua500 = textagua500.text

            val prefnom500 = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()

            prefnom500.putString("cancoca500"   ,cancoca500.toString())
            prefnom500.putString("cancocaz500"  , cancocaz500.toString())
            prefnom500.putString("cansprite500" , cansprite500.toString())
            prefnom500.putString("canfantan500" , canfantan500.toString())
            prefnom500.putString("canagua500"   , canagua500.toString())


            prefnom500.apply()

            findNavController().popBackStack()
        }

        return view
    }


}