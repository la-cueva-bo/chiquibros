package com.chiquibroaster

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class AuthActivity : AppCompatActivity() {

    companion object{
        private const val GOOGLE_SIGN_IN = 100
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar!!.hide()

        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        setup()
        session()




    }

    override fun onStart() {
        super.onStart()

        authLayout.visibility = View.VISIBLE
    }

    private fun session() {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val user = prefs.getString("user", null)
        val email = prefs.getString("email", null)
        val userId = prefs.getString("userId", null)

        if(email !=null && user !=null && userId != null){
            authLayout.visibility = View.INVISIBLE
            showHome(userId, user, email)
        }
    }

    private fun setup() {

        googleButton.setOnClickListener{
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            val googleClient = GoogleSignIn.getClient(this, googleConf)

            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == GOOGLE_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)

                if(account != null){

                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener{
                        if(it.isSuccessful){
                            val userId = account.id ?:""
                            val user = account.displayName ?:""
                            val email = account.email ?:""
                           showHome(userId, user, email)

                        }else{
                            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }catch(e: ApiException){
                Toast.makeText(this, "Obteniendo su información", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showHome(userId: String, user: String, email: String) {

        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("userId", userId)
            putExtra("user", user)
            putExtra("email", email)

            FirebaseMessaging.getInstance().isAutoInitEnabled = true
            FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->

                    if(!task.isSuccessful){
                        return@OnCompleteListener
                    }
                    val token = task.result?.token

                    val map = mutableMapOf<String, Any>()
                    map["user"] = user
                    map["email"] = email
                    map["token"] = token!!


                    val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                    prefs.putString("userId", userId)
                    prefs.putString("user", user)
                    prefs.putString("email", email)
                    prefs.putString("token", token)
                    prefs.apply()





                    val ref = FirebaseFirestore.getInstance().collection("Usuarios")
                    ref.document(userId).set(map)


                })




        }
        startActivity(homeIntent)

    }
}
