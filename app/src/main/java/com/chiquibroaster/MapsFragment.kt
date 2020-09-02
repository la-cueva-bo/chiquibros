package com.chiquibroaster

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_maps.*


class MapsFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location


    private var latituduser:Double? = null
    private var longituduser:Double? = null

    companion object {
        private const val REQUEST_LOCATION = 100

    }

    override fun onMarkerClick(p0: Marker?) = false

    private lateinit var googleMap: GoogleMap

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        maps.onCreate(savedInstanceState)
        maps.onResume()

        maps.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(AppChiqui.context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maps, container, false)
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

        fusedLocationClient.lastLocation.addOnSuccessListener {location ->

            if(location !=null){

                lastLocation = location
                latituduser = location.latitude
                longituduser = location.longitude

                if(latituduser!=null && longituduser!=null){
                    val currentlatlong = LatLng(latituduser!!, longituduser!!)

                    map?.addMarker(MarkerOptions().position(currentlatlong))
                    this.ConfirUbi.setOnClickListener{
                        val prefs = requireActivity().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                        prefs.putString("latitud", latituduser.toString())
                        prefs.putString("longitud", longituduser.toString())
                        prefs.apply()

                        findNavController().navigate(R.id.backAccion)
                    }
                    map?.animateCamera(CameraUpdateFactory.newLatLngZoom(currentlatlong, 16f))

                }


            }
        }
    }


}