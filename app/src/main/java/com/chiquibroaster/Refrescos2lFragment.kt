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


class Refrescos2lFragment : Fragment() {

    private var contador: Int? = 0
    private var contador1: Int? = 0
    private var contador2: Int? = 0
    private var contador3: Int? = 0
    private var contador4: Int? = 0
    private var contador5: Int? = 0
    private var contador6: Int? = 0
    private var contador7: Int? = 0
    private var contador8: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_refrescos2l, container, false)

        val confirefresco=view.findViewById<Button>(R.id.confirefresco)
        val botoncoca1 = view.findViewById<ImageButton>(R.id.coca1)
        val botoncoca2 = view.findViewById<ImageButton>(R.id.coca2)
        val botoncocaz1 = view.findViewById<ImageButton>(R.id.cocaz1)
        val botoncocaz2 = view.findViewById<ImageButton>(R.id.cocaz2)
        val botonsprite1 = view.findViewById<ImageButton>(R.id.sprite1)
        val botonsprite2 = view.findViewById<ImageButton>(R.id.sprite2)
        val botonfantan1 = view.findViewById<ImageButton>(R.id.fantan1)
        val botonfantan2 = view.findViewById<ImageButton>(R.id.fantan2)
        val botonfantam1 = view.findViewById<ImageButton>(R.id.fantam1)
        val botonfantam2 = view.findViewById<ImageButton>(R.id.fantam2)
        val botonfantapa1 = view.findViewById<ImageButton>(R.id.fantapa1)
        val botonfantapa2 = view.findViewById<ImageButton>(R.id.fantapa2)
        val botonfantapi1 = view.findViewById<ImageButton>(R.id.fantapi1)
        val botonfantapi2 = view.findViewById<ImageButton>(R.id.fantapi2)
        val botonfantag1 = view.findViewById<ImageButton>(R.id.fantag1)
        val botonfantag2 = view.findViewById<ImageButton>(R.id.fantag2)
        val botonmine1 = view.findViewById<ImageButton>(R.id.mine1)
        val botonmine2 = view.findViewById<ImageButton>(R.id.mine2)
        val textcoca = view.findViewById<TextView>(R.id.textcoca)
        val textcocaz = view.findViewById<TextView>(R.id.textcocaz)
        val textsprite = view.findViewById<TextView>(R.id.textsprite)
        val textfantan = view.findViewById<TextView>(R.id.textfantan)
        val textfantam = view.findViewById<TextView>(R.id.textfantam)
        val textfantapa = view.findViewById<TextView>(R.id.textfantapa)
        val textfantapi = view.findViewById<TextView>(R.id.textfantapi)
        val textfantag = view.findViewById<TextView>(R.id.textfantag)
        val textmine = view.findViewById<TextView>(R.id.textmine)


        if (contador==0){
            botoncoca2.isEnabled = false
        }
        botoncoca2.isEnabled = false
        botoncoca1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador!! + co!!)
            contador = suma
            if(contador != 0){
                botoncoca2.isEnabled = true
            }
            textcoca.text = suma.toString()
        }
        botoncoca2.setOnClickListener{
            val co:Int?=1
            val resta = (contador!!-co!!)
            contador=resta
            if(contador == 0){
                botoncoca2.isEnabled = false
            }
            textcoca.text=resta.toString()
        }

        if (contador1==0){
            botoncocaz2.isEnabled = false
        }
        botoncocaz2.isEnabled = false
        botoncocaz1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador1!! + co!!)
            contador1 = suma
            if(contador1 != 0){
                botoncocaz2.isEnabled = true
            }
            textcocaz.text = suma.toString()
        }
        botoncocaz2.setOnClickListener{
            val co:Int?=1
            val resta = (contador1!!-co!!)
            contador1=resta
            if(contador1 == 0){
                botoncocaz2.isEnabled = false
            }
            textcocaz.text=resta.toString()
        }

        if (contador2==0){
            botonsprite2.isEnabled = false
        }
        botonsprite2.isEnabled = false
        botonsprite1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador2!! + co!!)
            contador2 = suma
            if(contador2 != 0){
                botonsprite2.isEnabled = true
            }
            textsprite.text = suma.toString()
        }
        botonsprite2.setOnClickListener{
            val co:Int?=1
            val resta = (contador2!!-co!!)
            contador2=resta
            if(contador2 == 0){
                botonsprite2.isEnabled = false
            }
            textsprite.text=resta.toString()
        }

        if (contador3==0){
            botonfantan2.isEnabled = false
        }
        botonfantan2.isEnabled = false
        botonfantan1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador3!! + co!!)
            contador3 = suma
            if(contador3 != 0){
                botonfantan2.isEnabled = true
            }
            textfantan.text = suma.toString()
        }
        botonfantan2.setOnClickListener{
            val co:Int?=1
            val resta = (contador3!!-co!!)
            contador3=resta
            if(contador3 == 0){
                botonfantan2.isEnabled = false
            }
            textfantan.text=resta.toString()
        }

        if (contador4==0){
            botonfantam2.isEnabled = false
        }
        botonfantam2.isEnabled = false
        botonfantam1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador4!! + co!!)
            contador4 = suma
            if(contador4 != 0){
                botonfantam2.isEnabled = true
            }
            textfantam.text = suma.toString()
        }
        botonfantam2.setOnClickListener{
            val co:Int?=1
            val resta = (contador4!!-co!!)
            contador4=resta
            if(contador4 == 0){
                botonfantam2.isEnabled = false
            }
            textfantam.text=resta.toString()
        }

        if (contador5==0){
            botonfantapa2.isEnabled = false
        }
        botonfantapa2.isEnabled = false
        botonfantapa1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador5!! + co!!)
            contador5 = suma
            if(contador5 != 0){
                botonfantapa2.isEnabled = true
            }
            textfantapa.text = suma.toString()
        }
        botonfantapa2.setOnClickListener{
            val co:Int?=1
            val resta = (contador5!!-co!!)
            contador5=resta
            if(contador5 == 0){
                botonfantapa2.isEnabled = false
            }
            textfantapa.text=resta.toString()
        }

        if (contador6==0){
            botonfantapi2.isEnabled = false
        }
        botonfantapi2.isEnabled = false
        botonfantapi1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador6!! + co!!)
            contador6 = suma
            if(contador6 != 0){
                botonfantapi2.isEnabled = true
            }
            textfantapi.text = suma.toString()
        }
        botonfantapi2.setOnClickListener{
            val co:Int?=1
            val resta = (contador6!!-co!!)
            contador6=resta
            if(contador6 == 0){
                botonfantapi2.isEnabled = false
            }
            textfantapi.text=resta.toString()
        }

        if (contador7==0){
            botonfantag2.isEnabled = false
        }
        botonfantag2.isEnabled = false
        botonfantag1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador7!! + co!!)
            contador7 = suma
            if(contador7 != 0){
                botonfantag2.isEnabled = true
            }
            textfantag.text = suma.toString()
        }
        botonfantag2.setOnClickListener{
            val co:Int?=1
            val resta = (contador7!!-co!!)
            contador7=resta
            if(contador7 == 0){
                botonfantag2.isEnabled = false
            }
            textfantag.text=resta.toString()
        }

        if (contador8==0){
            botonmine2.isEnabled = false
        }
        botonmine2.isEnabled = false
        botonmine1.setOnClickListener{
            val co:Int? = 1
            val suma = (contador8!! + co!!)
            contador8 = suma
            if(contador8 != 0){
                botonmine2.isEnabled = true
            }
            textmine.text = suma.toString()
        }
        botonmine2.setOnClickListener{
            val co:Int?=1
            val resta = (contador8!!-co!!)
            contador8=resta
            if(contador8 == 0){
                botonmine2.isEnabled = false
            }
            textmine.text=resta.toString()
        }

        confirefresco.setOnClickListener {
            val cancoca2l = textcoca.text
            val cancocaz2l = textcocaz.text
            val cansprite2l = textsprite.text
            val canfantan2l = textfantan.text
            val canfantam2l = textfantam.text
            val canfantapa2l = textfantapa.text
            val canfantapi2l = textfantapi.text
            val canfantag2l = textfantag.text
            val canmine2l = textmine.text



            val prefnom2l = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()

            prefnom2l.putString("cancoca2l"     ,cancoca2l.toString())
            prefnom2l.putString("cancocaz2l"    , cancocaz2l.toString())
            prefnom2l.putString("cansprite2l"   , cansprite2l.toString())
            prefnom2l.putString("canfantan2l"   , canfantan2l.toString())
            prefnom2l.putString("canfantam2l"   , canfantam2l.toString())
            prefnom2l.putString("canfantapa2l"  , canfantapa2l.toString())
            prefnom2l.putString("canfantapi2l"  , canfantapi2l.toString())
            prefnom2l.putString("canfantag2l"   , canfantag2l.toString())
            prefnom2l.putString("canmine2l"     , canmine2l.toString())
            prefnom2l.apply()
            findNavController().popBackStack()

        }

        return view
    }


}