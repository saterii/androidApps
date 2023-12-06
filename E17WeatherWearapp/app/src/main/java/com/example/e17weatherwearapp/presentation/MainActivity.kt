package com.example.e17weatherwearapp.presentation

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.e17weatherwearapp.R
import java.time.Instant
import java.time.ZoneId


class MainActivity : ComponentActivity() {
    private val API_LINK: String = "https://api.openweathermap.org/data/2.5/weather?q="
    private val API_ICON: String = "https://openweathermap.org/img/w/"
    private val API_KEY: String = "api key was here"

    private lateinit var cityTextView: TextView
    private lateinit var tempTextView: TextView
    private lateinit var iconImageView: ImageView
    private lateinit var dateTextView: TextView
    private lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityTextView = findViewById(R.id.cityTextView)
        tempTextView = findViewById(R.id.tempTextView)
        iconImageView = findViewById(R.id.iconImageView)
        dateTextView = findViewById(R.id.dateTextView)
        requestQueue = Volley.newRequestQueue(this)

        loadData()
    }

    private fun loadData() {
        val city = "Jyväskylä"
        val url = "$API_LINK$city&APPID=$API_KEY&units=metric"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val mainJSONObject = response.getJSONObject("main")
                val weatherArray = response.getJSONArray("weather")
                val firstWeatherObject = weatherArray.getJSONObject(0)
                val iconCode = firstWeatherObject.getString("icon")
                val cityName = response.getString("name")

                val temperature = mainJSONObject.getString("temp") + " °C"

                // time
                val weatherTime: String = response.getString("dt")
                val weatherLong: Long = weatherTime.toLong()
                val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss")
                val dt = Instant.ofEpochSecond(weatherLong).atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter).toString()
                cityTextView.text = city
                tempTextView.text = temperature
                dateTextView.text = dt

                val iconUrl = "$API_ICON$iconCode.png"
                Glide.with(this@MainActivity)
                    .load(iconUrl)
                    .into(iconImageView)
            },
            { error ->
                error.printStackTrace()
            }
        )
        requestQueue.add(jsonObjectRequest)
    }
}