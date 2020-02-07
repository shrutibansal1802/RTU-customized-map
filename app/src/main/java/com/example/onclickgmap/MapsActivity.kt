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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        val Tpnt = LatLng(25.142090,75.807688)//T point
        mMap.addMarker(MarkerOptions().position(Tpnt).title("T Point"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tpnt))

        val latLngOrigin = LatLng(25.142490,75.806798) // library
        mMap.addMarker(MarkerOptions().position(latLngOrigin).title("Library"))

        val Dblock = LatLng(25.144265,75.804995) // D block
        mMap.addMarker(MarkerOptions().position(Dblock).title("D block"))

        val PNB = LatLng(25.143150,75.807046) // PNB
        mMap.addMarker(MarkerOptions().position(PNB).title("Punjab National Bank"))

        val LT = LatLng(25.144329,75.806465) // LT
        mMap.addMarker(MarkerOptions().position(LT).title("Lecture Theatere(LT)"))

        val Proc = LatLng(25.145161,75.805693) // Proctor
        mMap.addMarker(MarkerOptions().position(Proc).title("Proctor office"))

        val RMH = LatLng(25.144544,75.805954) // RMH
        mMap.addMarker(MarkerOptions().position(RMH).title("ramanuj hall-RMH"))


        val Cblock = LatLng(25.143976,75.805427)//T point
        mMap.addMarker(MarkerOptions().position(Cblock)
            .title("C Block - Mechanical department")
           // .icon(BitmapDescriptorFactory.fromResource(R.drawable.cblock))
        )



        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Tpnt, 16f))

        setMapStyle(mMap)
    }
}
