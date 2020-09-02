package com.chiquibroaster

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_seguimiento.*


class SeguimientoFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private var latus: Double? = null
    private var lonus: Double? = null
    private var latDel: String? = null
    private var lonDel: String? = null
    private var idDel: String? = null
    private var producto: String? = null
    private var total: String? = null
    private var est: String? = null
    private var time: String? = null
    private var idPed: String? = null

    private var direcDel: LatLng? = null
    private var marker: Marker? = null

    private lateinit var countDownTimer: CountDownTimer

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var lastLocation: Location

    private lateinit var googleMap: GoogleMap

    companion object {
        private const val REQUEST_LOCATION = 100

    }

    override fun onMarkerClick(p0: Marker?) = false


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mapView2.onCreate(savedInstanceState)
        mapView2.onResume()

        mapView2.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        idDel = SeguimientoFragmentArgs.fromBundle(requireArguments()).iddel
        producto = SeguimientoFragmentArgs.fromBundle(requireArguments()).prod
        total = SeguimientoFragmentArgs.fromBundle(requireArguments()).total
        est = SeguimientoFragmentArgs.fromBundle(requireArguments()).total
        time = SeguimientoFragmentArgs.fromBundle(requireArguments()).hora
        idPed = SeguimientoFragmentArgs.fromBundle(requireArguments()).idped
        latDel = SeguimientoFragmentArgs.fromBundle(requireArguments()).latdel
        lonDel = SeguimientoFragmentArgs.fromBundle(requireArguments()).londel



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_seguimiento, container, false)

        val prod = view.findViewById<TextView>(R.id.prodSegTextView)
        val tot = view.findViewById<TextView>(R.id.totalSegTextView)
        val hora = view.findViewById<TextView>(R.id.horaSegTextView)
        val estado = view.findViewById<TextView>(R.id.estadoSegTextView)

        prod.text = producto
        tot.text = total
        hora.text = time
        estado.text = est

        //countDownTimer = object : CountDownTimer(100000, 10000) {
        //    override fun onFinish() {
        //    }
//
        //    override fun onTick(millisUntilFinished: Long) {
//
        //        marker!!.remove()
        //        val db = FirebaseFirestore.getInstance().collection("Pedidos").document(idPed!!)
        //        db.get().addOnSuccessListener { snapshot ->
        //            latDel = snapshot.get("latitudDelivery").toString()
        //            lonDel = snapshot.get("longitudDelivery").toString()
//
        //        }
        //    }
        //}.start()

        return view
    }


    override fun onMapReady(map: GoogleMap?) {

        map?.let {
            googleMap = it
        }

        map?.setOnMarkerClickListener(this)
        map?.uiSettings?.isZoomControlsEnabled = true

        if (ActivityCompat.checkSelfPermission(
                AppChiqui.context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION
            )
        }
        map?.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->

            if (location != null) {
                lastLocation = location

                latus = location.latitude
                lonus = location.longitude
                val currentLatLong = LatLng(latus!!, lonus!!)

                if (latDel != null && lonDel != null) {
                    val delvLatLn = LatLng(latDel!!.toDouble(), lonDel!!.toDouble())
                    direcDel = delvLatLn
                    val markeroption = MarkerOptions().position(direcDel!!)
                    marker = map!!.addMarker(markeroption)
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(direcDel, 15f))
                    countDownTimer = object: CountDownTimer(3600000, 10000){
                        override fun onFinish() {

                        }

                        override fun onTick(millisUntilFinished: Long) {
                            marker?.remove()
                            val db = FirebaseFirestore.getInstance().collection("Pedidos").document(idPed!!)
                            db.get().addOnSuccessListener { documentSnapshot ->
                                if (documentSnapshot.exists()) {
                                    val latDel1 = documentSnapshot.get("latitudDelivery").toString()
                                    val lonDel1 = documentSnapshot.get("longitudDelivery").toString()
                                    val delvLatLn1 = LatLng(latDel1.toDouble(), lonDel1.toDouble())
                                    val markeroption1 = MarkerOptions().position(delvLatLn1)
                                    marker = map.addMarker(markeroption1)
                                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(delvLatLn1, 15f))


                                    Toast.makeText(context, "lat:$latDel1, lon:$lonDel1", Toast.LENGTH_SHORT).show()
                                }

                            }

                        }

                    }.start()

                } else {

                    map?.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 15f))


                }
            }

        }




    }
    override fun onDetach() {
        super.onDetach()
        countDownTimer.cancel()
    }
}