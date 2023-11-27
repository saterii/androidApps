package com.example.e10favouritecities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.e10favouritecities.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val jkl = LatLng(62.2, 25.7)
        mMap.addMarker(MarkerOptions().position(jkl).title("Marker in Jyväskylä"))
        mMap.addMarker(MarkerOptions().position(LatLng(64.1, 24.3)).title("Marker in Alavieska"))
        mMap.addMarker(MarkerOptions().position(LatLng(62.9, 27.7)).title("Marker in Kuopio"))
        mMap.addMarker(MarkerOptions().position(LatLng(70.1, 27.9)).title("Marker in Nuorgam"))
        mMap.addMarker(MarkerOptions().position(LatLng(64.3, 23.9)).title("Marker in Kalajoki"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jkl))
    }
    fun zoomIn(v: View){
        mMap.animateCamera(CameraUpdateFactory.zoomIn())
    }
    fun zoomOut(v: View){
        mMap.animateCamera(CameraUpdateFactory.zoomOut())
    }
}