package com.example.e09employeesappretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EmployeeAdapter(emptyList()) { clickedEmployee ->
            // Handle the clicked employee here
            val intent = Intent(this, EmployeeActivity::class.java)
            intent.putExtra("employee", Gson().toJson(clickedEmployee))
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://student.labranet.jamk.fi/~AB6912/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(EmployeeApiService::class.java)

        lifecycleScope.launch {
            try {
                val response = service.getEmployees()
                val employees = response.employees
                Log.d("MainActivity", "Fetched employees: $employees")
                adapter.updateData(employees)
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching employees: ${e.message}")
            }
        }
    }
}