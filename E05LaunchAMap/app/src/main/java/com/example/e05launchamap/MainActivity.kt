package com.example.e05launchamap

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun showMap(view: View){
        val lat = findViewById<EditText>(R.id.inputLatitude).text.toString()
        val lon = findViewById<EditText>(R.id.inputLongitude).text.toString()
        val location = Uri.parse("geo:$lat,$lon")
        val mapIntent = Intent(Intent.ACTION_VIEW, location)


        startActivity(mapIntent)

    }
}