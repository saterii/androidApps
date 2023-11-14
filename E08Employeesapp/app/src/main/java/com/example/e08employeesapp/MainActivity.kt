package com.example.e08employeesapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recycler1)

        recyclerView.layoutManager = LinearLayoutManager(this)
        loadJSON()
    }
    private fun loadJSON() {
        val queue = Volley.newRequestQueue(this)

        val url = "https://student.labranet.jamk.fi/~AB6912/employees.json"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->

                val employees = response.getJSONArray("employees")
                recyclerView.adapter = EmployeesAdapter(employees)
            },
            { error ->
                Log.d("JSON", error.toString())
            }
        )

        queue.add(jsonObjectRequest)

    }
    class EmployeesAdapter(private val employees: JSONArray)
        : RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : EmployeesAdapter.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.employee_item, parent, false)
            return ViewHolder(view)
        }

        // View Holder class to hold UI views
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameTextView: TextView = view.findViewById(R.id.nameTextView)
            val emailTextView: TextView = view.findViewById(R.id.emailTextView)
            val phoneTextView: TextView = view.findViewById(R.id.phoneTextView)
            val titleTextView: TextView = view.findViewById(R.id.titleTextView)
            val depTextView: TextView = view.findViewById(R.id.depTextView)
            val employeeImageView: ImageView = view.findViewById(R.id.employeeImageView)
            init {
                itemView.setOnClickListener {
                    val intent = Intent(view.context, EmployeeActivity::class.java)
                    intent.putExtra("employee",employees[adapterPosition].toString())
                    view.context.startActivity(intent)
                }
            }

        }
        override fun onBindViewHolder(
            holder: EmployeesAdapter.ViewHolder,
            position: Int)
        {
            // employee to bind UI
            val employee: JSONObject = employees.getJSONObject(position)
            // employee lastname and firstname
            // TASK: you can modify this to use formatting strings with placeholders
            holder.nameTextView.text =
                employee["lastName"].toString()+" "+ employee["firstName"].toString()
            holder.emailTextView.text =
                employee["email"].toString()
            holder.phoneTextView.text =
                employee["phone"].toString()
            holder.titleTextView.text =
                employee["title"].toString()
            holder.depTextView.text =
                employee["department"].toString()
            Glide.with(holder.itemView.context)
                .load(employee["image"])
                .into(holder.employeeImageView)
        }
        override fun getItemCount(): Int = employees.length()
    }

}