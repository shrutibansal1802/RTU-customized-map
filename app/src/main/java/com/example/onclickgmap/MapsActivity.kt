package com.example.onclickgmap

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private val TAG = MapsActivity::class.java.simpleName

    private fun setMapStyle(map: GoogleMap) {
        try {
            // Customize the styling of the base map using a JSON object defined
            // in a raw resource file.
            val success = map.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this,
                    R.raw.map_style
                )
            )
            if (!success) {
                Log.e(TAG, "Style parsing failed.")
            }
        }catch (e: Resources.NotFoundException) {
            Log.e(TAG, "Can't find style. Error: ", e)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        val Tpnt = LatLng(25.142090,75.807688)//T point
        mMap.addMarker(MarkerOptions().position(Tpnt).title("T Point"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tpnt))

        val libra = LatLng(25.142490,75.806798) // library
        mMap.addMarker(MarkerOptions().position(libra).title("Library"))

        val Dblock = LatLng(25.144265,75.804995) // D block
        mMap.addMarker(MarkerOptions().position(Dblock).title("D block"))

        val Cblock = LatLng(25.143976,75.805427)//C block
        mMap.addMarker(MarkerOptions().position(Cblock).title("C Block - Mechanical department"))


        val Bblock = LatLng(25.143732,75.808528) // B block
        mMap.addMarker(MarkerOptions().position(Bblock).title("b block- Civil department"))


        val Ablock = LatLng(25.143555,75.806224) // A block
        mMap.addMarker(MarkerOptions().position(Ablock).title("A block -electrical department"))

        val PNB = LatLng(25.143150,75.807046) // PNB
        mMap.addMarker(MarkerOptions().position(PNB).title("Punjab National Bank"))

        val LT = LatLng(25.144329,75.806465) // LT
        mMap.addMarker(MarkerOptions().position(LT).title("Lecture Theatere(LT)"))

        val Proc = LatLng(25.145161,75.805693) // Proctor
        mMap.addMarker(MarkerOptions().position(Proc).title("Proctor office"))


        val Agora = LatLng(25.142775,75.806358) // Proctor
        mMap.addMarker(MarkerOptions().position(Agora).title("Agora"))

        val RMH = LatLng(25.144544,75.805954) // RMH
        mMap.addMarker(MarkerOptions().position(RMH).title("ramanuj hall-RMH"))


        val petro = LatLng(25.142439,75.805619) // petro building
        mMap.addMarker(MarkerOptions().position(petro).title("Petroleum building"))


        val CS  = LatLng(25.141700,75.806839)
        mMap.addMarker(MarkerOptions().position(CS).title("Computer Science Department"))


        val dispensary = LatLng(25.141212,75.807399)
        mMap.addMarker(MarkerOptions().position(dispensary).title("Dispensary"))


        val canteen  = LatLng(25.140987,75.807285)
        mMap.addMarker(MarkerOptions().position(canteen).title("Canteen"))


        val girlshostel  = LatLng(25.144544,75.805954)
        mMap.addMarker(MarkerOptions().position(girlshostel).title("Girls Hostel"))


        val pnb_atm = LatLng(25.139682,75.810956)
        mMap.addMarker(MarkerOptions().position(pnb_atm).title("PNB ATM"))


        val main_gate = LatLng(25.139733,75.811074)
        mMap.addMarker(MarkerOptions().position(main_gate).title("Main Gate"))


        val hpoint = LatLng(25.140770,75.809473)
        mMap.addMarker(MarkerOptions().position(hpoint).title("H- point"))


        val gym  = LatLng(25.139913,75.808180)
        mMap.addMarker(MarkerOptions().position(gym).title("Gymnasium"))

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Tpnt, 16f))

        setMapStyle(mMap)
    }
}
