package com.chiquibroaster

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*


class FacturaFragment : Fragment() {

    private var titulo:String?=null
    private var canplatano:String?=null
    private var canpapas:String?=null
    private var canarroz:String?=null
    private var canpierna:String?=null
    private var canpecho:String?=null

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
    private var preciototal:String? ="0"
    private var ubicacion: String?= "0"
    private var latitud: String? = null
    private var longitud: String? = null

    private var userId:String? = null
    private var username:String? = null
    private var useremail:String? = null
    private var token:String? = null

    private var anhoac:Int? = null
    private var mesac:Int? = null
    private var diaac:Int? = null
    private var horaac:Int? = null
    private var minac:Int? = null



    private var cal= Calendar.getInstance()


    companion object {
        private const val REQUEST_LOCATION = 100

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prefs = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)

        userId = prefs.getString("userId", "")
        username = prefs.getString("user", "")
        useremail = prefs.getString("email", "")
        token = prefs.getString("token", "")
        titulo  =   prefs.getString("titulo", "")
        canplatano =prefs.getString("cantidadPlatano", "0")
        canpapas  = prefs.getString("cantidadPapas", "0")
        canarroz  = prefs.getString("cantidadArroz", "0")
        canpierna = prefs.getString("cantidadPierna", "0")
        canpecho  = prefs.getString("cantidadPecho", "0")
        contador5 = prefs.getString("cancoca2l","0")
        contador6 = prefs.getString("cancocaz2l", "0")
        contador7 = prefs.getString("cansprite2l", "0")
        contador8 = prefs.getString("canfantan2l", "0")
        contador9 = prefs.getString("canfantam2l", "0")
        contador10 = prefs.getString("canfantapa2l", "0")
        contador11 = prefs.getString("canfantapi2l", "0")
        contador12 = prefs.getString("canfantag2l", "0")
        contador13 = prefs.getString("canmine2l",  "0")
        contador14 = prefs.getString("cancoca500", "0")
        contador15 = prefs.getString("cancocaz500", "0")
        contador16 = prefs.getString("cansprite500", "0")
        contador17 = prefs.getString("canfantan500", "0")
        contador18 = prefs.getString("canagua500", "0")
        preciototal = prefs.getString("preciototal","0")



        cal = Calendar.getInstance()
        anhoac = cal.get(Calendar.YEAR)
        mesac = cal.get(Calendar.MONTH)
        diaac = cal.get(Calendar.DAY_OF_MONTH)
        horaac = cal.get(Calendar.HOUR_OF_DAY)
        minac  = cal.get(Calendar.MINUTE)


    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_factura, container, false)

        val titulofactura = view.findViewById<TextView>(R.id.TituloFactura)

        val bot = view.findViewById<ImageButton>(R.id.locButton)
        val confboton=view.findViewById<Button>(R.id.confirmarButton)
        val nombreFac=view.findViewById<EditText>(R.id.nombFacEditText)
        val nitFac=view.findViewById<EditText>(R.id.nitFacEditText)
        val phoneFac=view.findViewById<EditText>(R.id.phoneFacEditText)
        val locFac=view.findViewById<EditText>(R.id.locFacEditText)
        val presa1=view.findViewById<TextView>(R.id.facturapresa1)
        val presa2=view.findViewById<TextView>(R.id.facturapresa2)
        val fac1=view.findViewById<TextView>(R.id.textView16)
        val fac2=view.findViewById<TextView>(R.id.textView17)
        val fac3=view.findViewById<TextView>(R.id.textView19)
        val ref1=view.findViewById<TextView>(R.id.ref1)
        val ref2=view.findViewById<TextView>(R.id.ref2)
        val ref3=view.findViewById<TextView>(R.id.ref3)
        val ref4=view.findViewById<TextView>(R.id.ref4)
        val ref5=view.findViewById<TextView>(R.id.ref5)
        val ref6=view.findViewById<TextView>(R.id.ref6)
        val ref7=view.findViewById<TextView>(R.id.ref7)
        val ref8=view.findViewById<TextView>(R.id.ref8)
        val ref9=view.findViewById<TextView>(R.id.ref9)
        val ref10=view.findViewById<TextView>(R.id.ref10)
        val ref11=view.findViewById<TextView>(R.id.ref11)
        val ref12=view.findViewById<TextView>(R.id.ref12)
        val ref13=view.findViewById<TextView>(R.id.ref13)
        val ref14=view.findViewById<TextView>(R.id.ref14)
        val total=view.findViewById<TextView>(R.id.texttotal)


        titulofactura.text=titulo
        total.text=preciototal

        if(canpecho!="0"){
            presa1.text="Presa: Pecho/Ala ($canpecho)"
        }else{
            presa1.isVisible = false
        }

        if(canpierna!="0"){
            presa2.text="Presa: Pierna/Entrepierna ($canpierna)"
        }else{
            presa2.isVisible = false
        }

        if(canarroz!= "0"){
            fac1.text="Arroz: ($canarroz)"
        }else{
            fac1.isVisible = false
        }
        if(canpapas!= "0"){
            fac2.text="Papas: ($canpapas)"
        }else{
            fac2.isVisible = false
        }
        if(canplatano!= "0"){
            fac3.text="Platano: ($canplatano)"
        }else{
            fac3.isVisible=false
        }
        if(contador5!="0"){
            ref1.text="Coca Cola2L: ($contador5)"
        }else{
            ref1.isVisible = false
        }

        if(contador6!="0"){
            ref2.text="Coca Cola zero 2l: ($contador6)"
        }else {
            ref2.isVisible = false
        }
        if(contador7!="0"){
            ref3.text="sprite_2l: ($contador7)"
        }else {
            ref3.isVisible = false
        }
        if(contador8!="0"){
            ref4.text="fanta_naranja_2l: ($contador8)"
        }else {
            ref4.isVisible = false
        }
        if(contador9!="0"){
            ref5.text="fanta_mandarina_2l: ($contador9)"
        }else {
            ref5.isVisible = false
        }
        if(contador10!="0"){
            ref6.text="fanta_papaya_2l: ($contador10)"
        }else {
            ref6.isVisible = false
        }
        if(contador11!="0"){
            ref7.text="fanta_piña_2l: ($contador11)"
        }else {
            ref7.isVisible = false
        }
        if(contador12!="0"){
            ref8.text="fanta_guarana_2l: ($contador12)"
        }else {
            ref8.isVisible = false
        }
        if(contador13!="0"){
            ref9.text="mineragua_2l: ($contador13)"
        }else {
            ref9.isVisible = false
        }
        if(contador14!="0"){
            ref10.text="coca_cola_500ml: ($contador14)"
        }else {
            ref10.isVisible = false
        }
        if(contador15!="0"){
            ref11.text="coca_zero_500ml: ($contador15)"
        }else {
            ref11.isVisible = false
        }
        if(contador16!="0"){
            ref12.text="sprite_500ml: ($contador16)"
        }else {
            ref12.isVisible = false
        }
        if (contador17 != "0") {
            ref13.text = "fanta_naranja_500ml: ($contador17)"
        } else {
            ref13.isVisible = false
        }
        if (contador18 != "0") {
            ref14.text = "agua_500ml: ($contador18)"
        } else {
            ref14.isVisible = false
        }

        bot.setOnClickListener{
            if (ActivityCompat.checkSelfPermission(
                    AppChiqui.context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_LOCATION
                )
            } else {
                findNavController().navigate(R.id.ubiAccion)
            }
        }

        confboton.setOnClickListener {
            if (phoneFac.text.isNotEmpty() && locFac.text.isNotEmpty()){
                val prefs = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
                ubicacion = prefs.getString("ubicacion","")
                latitud = prefs.getString("latitud", null)
                longitud = prefs.getString("longitud", null)

                if(latitud!=null&&longitud!=null){
                    val map = mutableMapOf<String, Any>()
                    map["usuarioId"] = userId!!
                    map["userNombre"] = username!!
                    map["userEmail"] = useremail!!
                    map["Producto"] = titulo!!
                    map["telefono"] = phoneFac.text.toString()
                    map["ubicacion"] = locFac.text.toString()
                    map["latitud"] = latitud.toString()
                    map["longitud"] = longitud.toString()
                    map["nombreFactura"] = nombreFac.text.toString()
                    map["nit"] = nitFac.text.toString()
                    map["fecha_pedido"] = "$anhoac/$mesac/$diaac"
                    map["total"] = preciototal!!
                    map["estadoPedido"] = "PENDIENTE"
                    map["token"] = token!!
                    map["hora_ped"] = SimpleDateFormat("HH:mm").format(cal.time)

                    if (canpecho != "0") {
                        map["presa"] = "Pecho/ala"
                        map["cantidadpechos"] = canpecho.toString()

                    }
                    if (canpierna != "0") {
                        map["presa2"] = "Pierna/Entrepierna"
                        map["cantidadpiernas"] = canpierna.toString()
                    }
                    if (canarroz != "0") {
                        map["arrozExtra"] = canarroz.toString()

                    }
                    if (canpapas != "0") {
                        map["papaExtra"] = canpapas.toString()
                    }
                    if (canplatano != "0") {
                        map["platanoExtra"] = canplatano.toString()
                    }
                    if (contador5 != "0") {
                        map["coca_cola_2l"] = contador5!!
                    }

                    if (contador6 != "0") {
                        map["coca_cola_zero_2l"] = contador6!!
                    }

                    if (contador7 != "0") {
                        map["sprite_2l"] = contador7!!
                    }

                    if (contador8 != "0") {
                        map["fanta_naranja_2l"] = contador8!!
                    }

                    if (contador9 != "0") {
                        map["fanta_mandarina_2l"] = contador9!!
                    }

                    if (contador10 != "0") {
                        map["fanta_papaya_2l"] = contador10!!
                    }

                    if (contador11 != "0") {
                        map["fanta_piña_2l"] = contador11!!
                    }

                    if (contador12 != "0") {
                        map["fanta_guarana_2l"] = contador12!!
                    }

                    if (contador13 != "0") {
                        map["mineragua_2l"] = contador13!!
                    }
                    if (contador14 != "0") {
                        map["coca_cola_500ml"] = contador14!!
                    }

                    if (contador15 != "0") {
                        map["coca_zero_500ml"] = contador15!!
                    }

                    if (contador16 != "0") {
                        map["sprite_500ml"] = contador16!!
                    }

                    if (contador17 != "0") {
                        map["fanta_naranja_500ml"] = contador17!!
                    }

                    if (contador18 != "0") {
                        map["agua_500ml"] = contador18!!
                    }

                    val ref = FirebaseFirestore.getInstance().collection("Pedidos")
                    ref.document().set(map)



                    val prefsClr = requireActivity().getSharedPreferences(
                        getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                    prefsClr.remove("titulo")
                    prefsClr.remove("cantidadPlatano")
                    prefsClr.remove("cantidadPapas")
                    prefsClr.remove("cantidadArroz")
                    prefsClr.remove("cantidadPierna")
                    prefsClr.remove("cantidadPecho")
                    prefsClr.remove("cancoca2l")
                    prefsClr.remove("cancocaz2l")
                    prefsClr.remove("cansprite2l")
                    prefsClr.remove("canfantan2l")
                    prefsClr.remove("canfantam2l")
                    prefsClr.remove("canfantapa2l")
                    prefsClr.remove("canfantapi2l")
                    prefsClr.remove("canfantag2l")
                    prefsClr.remove("canmine2l")
                    prefsClr.remove("cancoca500")
                    prefsClr.remove("cancocaz500")
                    prefsClr.remove("cansprite500")
                    prefsClr.remove("canfantan500")
                    prefsClr.remove("canagua500")
                    prefsClr.remove("preciototal")
                    prefsClr.remove("ubicacion")
                    prefsClr.remove("latitud")
                    prefsClr.remove("longitud")

                    prefsClr.apply()

                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("SU PEDIDO FUE REGISTRADO!")
                    builder.setMessage("Atendido por sus propietarios, gracias por su preferencia")
                    builder.setPositiveButton("ACEPTAR") { dialog, _ ->
                        val logout = Intent(AppChiqui.context, AuthActivity::class.java)
                        requireActivity().startActivity(logout)
                        requireActivity().finishAffinity()
                        dialog.dismiss()


                    }
                    val dialog: AlertDialog = builder.create()
                    dialog.show()

                }else{
                    Toast.makeText(context, "Debe marcar su ubicación en el mapa", Toast.LENGTH_LONG).show()
                }

            }else {
                Toast.makeText(context, "Debe ingresar los datos oblgatorios",Toast.LENGTH_SHORT).show()
            }

        }

        return view
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode){
            REQUEST_LOCATION -> {
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    findNavController().navigate(R.id.ubiAccion)
                else
                    Toast.makeText(requireContext(), "No se pudo acceder al mapa", Toast.LENGTH_LONG).show()
            }
        }
    }


}