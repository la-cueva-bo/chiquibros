package com.chiquibroaster.ui.perfil

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chiquibroaster.AppChiqui
import com.chiquibroaster.AuthActivity
import com.chiquibroaster.R
import com.google.firebase.auth.FirebaseAuth

class PerfilFragment : Fragment() {

    private var nombre: String? = null
    private var correo: String? = null
    private var userId:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        nombre = prefs.getString("user", "")
        correo = prefs.getString("email", "")
        userId = prefs.getString("userId", "")

        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val perfil = inflater.inflate(R.layout.fragment_gallery, container, false)

        val username = perfil.findViewById<TextView>(R.id.userTextView)
        val usermail = perfil.findViewById<TextView>(R.id.emailTextView)
        val buttonLogOut = perfil.findViewById<Button>(R.id.SignOutButton)
        val pedidos = perfil.findViewById<TextView>(R.id.textView23)


        username.text = nombre
        usermail.text = correo


        pedidos.setOnClickListener {
            findNavController().navigate(R.id.actionPedHist)
        }

        buttonLogOut.setOnClickListener {
            val prefs = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()

            FirebaseAuth.getInstance().signOut()

            val logOut = Intent(AppChiqui.context, AuthActivity::class.java)
            requireActivity().startActivity(logOut)
            requireActivity().finishAffinity()

        }

        return perfil
    }
}