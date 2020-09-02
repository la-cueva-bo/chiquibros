package com.chiquibroaster

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import com.google.firebase.firestore.FirebaseFirestore


class TiempoFragment : Fragment() {

    private var delId: String? = null
    private var idPed: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        delId = TiempoFragmentArgs.fromBundle(requireArguments()).delid
        idPed = TiempoFragmentArgs.fromBundle(requireArguments()).idped

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tiempo, container, false)

        val delraitin = view.findViewById<RatingBar>(R.id.DelRatingBar)
        val pedraitin = view.findViewById<RatingBar>(R.id.PedRatingBar)
        val send = view.findViewById<Button>(R.id.enviarCalificacionButton)
        val delfinal = view.findViewById<EditText>(R.id.delFinalEditText)
        val pedfinal = view.findViewById<EditText>(R.id.pedFinalEditText)


        send.setOnClickListener {

            if(delfinal.text.isNotEmpty()&&pedfinal.text.isNotEmpty()){
                val stars1 = delraitin.rating
                val stars2 = pedraitin.rating
                val delDet = delfinal.text.toString()
                val pedDet = pedfinal.text.toString()

                val map = mutableMapOf<String, Any>()
                map["cantidad_estrellas"] = stars1
                map["detalle_calificacion"] = delDet

                val map2 = mutableMapOf<String, Any>()
                map2["cantidad_estrellas"] = stars2
                map2["detalle_calificacion"] = pedDet

                val db = FirebaseFirestore.getInstance().collection("Deliverys").document(delId!!).collection("Calificacion")
                db.document(idPed!!).set(map)

                val fs = FirebaseFirestore.getInstance().collection("Calificacion")
                fs.document(idPed!!).set(map2)

                val store = FirebaseFirestore.getInstance().collection("Pedidos").document(idPed!!)
                store.update("estadoPedido", "ENTREGADO")

                val builder = AlertDialog.Builder(context)
                builder.setTitle("GRACIAS POR SU COLABORACIÓN")
                builder.setMessage("Los datos fueron enviados, puede continuar")
                builder.setPositiveButton("ACEPTAR"){ _, _ ->
                    val logOut = Intent(AppChiqui.context, AuthActivity::class.java)
                    requireActivity().startActivity(logOut)
                    requireActivity().finishAffinity()
                }
                val alert = builder.create()
                alert.show()

            }else{
                val stars1 = delraitin.rating
                val stars2 = pedraitin.rating
                val delDet = ""
                val pedDet = ""

                val map = mutableMapOf<String, Any>()
                map["cantidad_estrellas"] = stars1
                map["detalle_calificacion"] = delDet

                val map2 = mutableMapOf<String, Any>()
                map2["cantidad_estrellas"] = stars2
                map2["detalle_calificacion"] = pedDet

                val db = FirebaseFirestore.getInstance().collection("Deliverys").document(delId!!).collection("Calificacion")
                db.document(idPed!!).set(map)

                val fs = FirebaseFirestore.getInstance().collection("Calificacion")
                fs.document(idPed!!).set(map2)

                val store = FirebaseFirestore.getInstance().collection("Pedidos").document(idPed!!)
                store.update("estadoPedido", "ENTREGADO")



                val builder = AlertDialog.Builder(context)
                builder.setTitle("GRACIAS POR SU COLABORACIÓN")
                builder.setMessage("Los datos fueron enviados, puede continuar")
                builder.setPositiveButton("ACEPTAR"){ _, _ ->
                    val logOut = Intent(AppChiqui.context, AuthActivity::class.java)
                    requireActivity().startActivity(logOut)
                    requireActivity().finishAffinity()
                }
                val alert = builder.create()
                alert.show()
            }
        }

        return view
    }


}