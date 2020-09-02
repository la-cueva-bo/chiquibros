package com.chiquibroaster

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide


class PedidoFragment : Fragment() {

    private var arroz:String="ARROZ"
    private var papa:String="PAPAS"
    private var platano:String="PLATANO"
    private var titulo:String?="TITULO"
    private var imagenrecibe:String?= "imagen"
    private var imagenFBarroz:String?= "null"
    private var imagenFBpapa:String?= "null"
    private var imagenFBplatano:String?= "null"
    private var imagenpre:String?= "null"

    private var contador:Int? = 0
    private var contador1:Int? = 0
    private var contador2:Int? = 0
    private var contador3:Int? = 0
    private var contador4:Int? = 0

    private var preciopollo:String? =null
    private var precioextraa:Int? = 10
    private var precioextrapa:Int? = 12
    private var precioextrapla:Int? = 5
    private var precior2l:Int? = 10
    private var precior500:Int? = 6
    private var preciototal:String? = "0"


    private var contador5: String? = "0"
    private var contador6: String? = "0"
    private var contador7: String? = "0"
    private var contador8: String? = "0"
    private var contador9: String? = "0"
    private var contador10: String? = "0"
    private var contador11: String? = "0"
    private var contador12: String? = "0"
    private var contador13: String? = "0"
    private var contador14:String? ="0"
    private var contador15:String? ="0"
    private var contador16:String? ="0"
    private var contador17:String? ="0"
    private var contador18:String? ="0"


    private var canpecho:String?= "0"
    private var canpierna:String?= "0"
    private var canarroz:String?= "0"
    private var canpapas:String?= "0"
    private var canplatano:String?= "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        titulo = arguments?.let { PedidoFragmentArgs.fromBundle(
            it
        ).titulo }
        arroz = PedidoFragmentArgs.fromBundle(requireArguments()).arroz
        papa = PedidoFragmentArgs.fromBundle(
            requireArguments()
        ).papas
        platano = PedidoFragmentArgs.fromBundle(
            requireArguments()
        ).platano
        imagenrecibe = PedidoFragmentArgs.fromBundle(
            requireArguments()
        ).imagenstandard
        imagenFBarroz = PedidoFragmentArgs.fromBundle(
            requireArguments()
        ).imaArr

        imagenFBpapa = PedidoFragmentArgs.fromBundle(
            requireArguments()
        ).imaPa

        imagenFBplatano = PedidoFragmentArgs.fromBundle(
            requireArguments()
        ).imaPl

        imagenpre = PedidoFragmentArgs.fromBundle(
            requireArguments()
        ).impre

        preciopollo= PedidoFragmentArgs.fromBundle(requireArguments()).precio


        val prefnom2l = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()

        prefnom2l.putString("cancoca2l","0")
        prefnom2l.putString("cancocaz2l", "0")
        prefnom2l.putString("cansprite2l", "0")
        prefnom2l.putString("canfantan2l", "0")
        prefnom2l.putString("canfantam2l", "0")
        prefnom2l.putString("canfantapa2l", "0")
        prefnom2l.putString("canfantapi2l", "0")
        prefnom2l.putString("canfantag2l", "0")
        prefnom2l.putString("canmine2l", "0")
        prefnom2l.putString("cancoca500", "0")
        prefnom2l.putString("cancocaz500", "0")
        prefnom2l.putString("cansprite500", "0")
        prefnom2l.putString("canfantan500", "0")
        prefnom2l.putString("canagua500", "0")
        prefnom2l.apply()



        retainInstance = true

    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pedido, container, false)

        val button = view.findViewById<Button>(R.id.confirmarButton)

        val buton=view.findViewById<ImageButton>(R.id.sumaButton)
        val buuton=view.findViewById<ImageButton>(R.id.restaButton)
        val bbuton=view.findViewById<ImageButton>(R.id.sumButton)
        val buttoon=view.findViewById<ImageButton>(R.id.resButton)
        val butonn=view.findViewById<ImageButton>(R.id.imageButton6)
        val boton=view.findViewById<ImageButton>(R.id.imageButton7)
        val bboton=view.findViewById<ImageButton>(R.id.imageButton8)
        val booton=view.findViewById<ImageButton>(R.id.imageButton9)
        val botton=view.findViewById<ImageButton>(R.id.imageButton10)
        val botoon=view.findViewById<ImageButton>(R.id.imageButton11)
        val boton2l=view.findViewById<ImageButton>(R.id.imageButtonRefresco2l)
        val boton500ml=view.findViewById<ImageButton>(R.id.imageButtonRefrescos500ml)
        val titulopedido=view.findViewById<TextView>(R.id.textViewTitulo)
        val guarniciones=view.findViewById<TextView>(R.id.textViewGuarniciones)
        val imagenPedido=view.findViewById<ImageView>(R.id.imagepedidopollo)
        val imagenarroz=view.findViewById<ImageView>(R.id.imageViewA)
        val imagenpapa=view.findViewById<ImageView>(R.id.imageViewP)
        val imagenplatano=view.findViewById<ImageView>(R.id.imageViewL)
        val cantpecho=view.findViewById<TextView>(R.id.cantTextView)
        val cantpierna=view.findViewById<TextView>(R.id.canttextView15)
        val cantarr=view.findViewById<TextView>(R.id.textView1)
        val cantpap=view.findViewById<TextView>(R.id.textView2)
        val cantpla=view.findViewById<TextView>(R.id.textView3)
        val imagenpresa=view.findViewById<ImageView>(R.id.phaImageView)
        val imagenpresas=view.findViewById<ImageView>(R.id.ppeImageView)

        cantpecho.text = contador.toString()
        cantpierna.text = contador1.toString()
        cantarr.text = contador2.toString()
        cantpap.text = contador3.toString()
        cantpla.text = contador4.toString()

        if (contador==0){
            buuton.isEnabled = false
        }

        buuton.isEnabled = false
        buton.setOnClickListener{
            val co:Int? = 1
            val suma = (contador!! + co!!)
            contador = suma
            if(contador != 0){
                buuton.isEnabled = true
            }
            cantpecho.text = suma.toString()
        }
        buuton.setOnClickListener{
            val co:Int?=1
            val resta = (contador!!-co!!)
            contador=resta
            if(contador == 0){
                buuton.isEnabled = false
            }
            cantpecho.text=resta.toString()
        }

        if (contador1==0){
            buttoon.isEnabled = false
        }
        buttoon.isEnabled = false
        bbuton.setOnClickListener{
            val co:Int? = 1
            val suma = (contador1!! + co!!)
            contador1 = suma
            if(contador1 != 0){
                buttoon.isEnabled = true
            }
            cantpierna.text = suma.toString()
        }
        buttoon.setOnClickListener{
            val co:Int?=1
            val resta = (contador1!!-co!!)
            contador1=resta
            if(contador1 == 0){
                buttoon.isEnabled = false
            }
            cantpierna.text=resta.toString()
        }

        if (contador2==0){
            boton.isEnabled = false
        }
        boton.isEnabled = false
        butonn.setOnClickListener{
            val co:Int? = 1
            val suma = (contador2!! + co!!)
            contador2 = suma
            if(contador2 != 0){
                boton.isEnabled = true
            }
            cantarr.text = suma.toString()
        }
        boton.setOnClickListener{
            val co:Int?=1
            val resta = (contador2!!-co!!)
            contador2=resta
            if(contador2 == 0){
                boton.isEnabled = false
            }
            cantarr.text=resta.toString()
        }

        if (contador3==0){
            booton.isEnabled = false
        }
        booton.isEnabled = false
        bboton.setOnClickListener{
            val co:Int? = 1
            val suma = (contador3!! + co!!)
            contador3 = suma
            if(contador3 != 0){
                booton.isEnabled = true
            }
            cantpap.text = suma.toString()
        }
        booton.setOnClickListener{
            val co:Int?=1
            val resta = (contador3!!-co!!)
            contador3=resta
            if(contador3 == 0){
                booton.isEnabled = false
            }
            cantpap.text=resta.toString()
        }

        if (contador4==0){
            botoon.isEnabled = false
        }
        botoon.isEnabled = false
        botton.setOnClickListener{
            val co:Int? = 1
            val suma = (contador4!! + co!!)
            contador4 = suma
            if(contador4 != 0){
                botoon.isEnabled = true
            }
            cantpla.text = suma.toString()
        }

        botoon.setOnClickListener{
            val co:Int?=1
            val resta = (contador4!!-co!!)
            contador4=resta
            if(contador4 == 0){
                botoon.isEnabled = false
            }
            cantpla.text=resta.toString()
        }


        titulopedido?.text= titulo
        guarniciones?.text= "  $arroz   $papa   $platano"
        imagenPedido?.let{
            Glide.with(AppChiqui.context).load(imagenrecibe).into(imagenPedido)
        }
        imagenarroz?.let{
            Glide.with(AppChiqui.context).load(imagenFBarroz).into(imagenarroz)
        }

        imagenpapa?.let{
            Glide.with(AppChiqui.context).load(imagenFBpapa).into(imagenpapa)
        }
        imagenplatano?.let{
            Glide.with(AppChiqui.context).load(imagenFBplatano).into(imagenplatano)
        }

        imagenpresa?.let{
            Glide.with(AppChiqui.context).load(imagenrecibe).into(imagenpresa)
        }

        imagenpresas?.let{
            Glide.with(AppChiqui.context).load(imagenpre).into(imagenpresas)
        }




        boton2l.setOnClickListener {

            findNavController().navigate(R.id.action2l)
        }
        boton500ml.setOnClickListener {

            findNavController().navigate(R.id.action500ml)
        }

        button.setOnClickListener {
            canpecho = cantpecho.text.toString()
            canpierna = cantpierna.text.toString()
            canarroz = cantarr.text.toString()
            canpapas = cantpap.text.toString()
            canplatano = cantpla.text.toString()


            if(canpecho=="0"&&canpierna=="0"){
                Toast.makeText(context, "Debe seleccionar un producto", Toast.LENGTH_LONG).show()
            }else{

                val prefnom = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
                contador5=  prefnom.getString("cancoca2l","")
                contador6=  prefnom.getString("cancocaz2l", "")
                contador7=  prefnom.getString("cansprite2l", "")
                contador8=  prefnom.getString("canfantan2l", "")
                contador9=  prefnom.getString("canfantam2l", "")
                contador10=  prefnom.getString("canfantapa2l", "")
                contador11=  prefnom.getString("canfantapi2l", "")
                contador12=  prefnom.getString("canfantag2l", "")
                contador13=  prefnom.getString("canmine2l", "")
                contador14= prefnom.getString("cancoca500","")
                contador15= prefnom.getString("cancocaz500","")
                contador16= prefnom.getString("cansprite500","")
                contador17= prefnom.getString("canfantan500", "")
                contador18= prefnom.getString("canagua500","")

                val subtotal =  (preciopollo!!.toInt()*canpecho!!.toInt())+(preciopollo!!.toInt()*canpierna!!.toInt())+(precioextraa!!*canarroz!!.toInt())+(precioextrapa!!*canpapas!!.toInt())+(precioextrapla!!*canplatano!!.toInt())+(precior2l!!*contador5!!.toInt())+(precior2l!!*contador6!!.toInt())+(precior2l!!*contador7!!.toInt())+(precior2l!!*contador8!!.toInt())+(precior2l!!*contador9!!.toInt())+(precior2l!!*contador10!!.toInt())+(precior2l!!*contador11!!.toInt())+(precior2l!!*contador12!!.toInt())+(precior2l!!*contador13!!.toInt())+(precior500!!*contador14!!.toInt())+(precior500!!*contador15!!.toInt())+(precior500!!*contador16!!.toInt())+(precior500!!*contador17!!.toInt())+(precior500!!*contador18!!.toInt())
                preciototal = subtotal.toString()




                val prefs = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                prefs.putString("titulo", titulo)
                prefs.putString("cantidadPlatano", canplatano)
                prefs.putString("cantidadPapas", canpapas)
                prefs.putString("cantidadArroz", canarroz)
                prefs.putString("cantidadPierna", canpierna)
                prefs.putString("cantidadPecho", canpecho)
                prefs.putString("preciototal",preciototal)

                prefs.apply()


                findNavController().navigate(R.id.actionFactura)
            }
        }

        return view
    }


}