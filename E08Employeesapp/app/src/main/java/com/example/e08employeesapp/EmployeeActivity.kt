package com.example.e08employeesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import org.json.JSONObject

class EmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val phoneTextView = findViewById<TextView>(R.id.phoneTextView)
        val depTextView = findViewById<TextView>(R.id.depTextView)
        val descTextView = findViewById<TextView>(R.id.descTextView)
        val empImageView = findViewById<ImageView>(R.id.employeeImageView)


        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val employeeString = bundle.getString("employee")
            if (employeeString != null) {
                val employee = JSONObject(employeeString)
                nameTextView.text = employee["firstName"].toString() + " " + employee["lastName"].toString()
                titleTextView.text = employee["title"].toString()
                emailTextView.text = employee["email"].toString()
                phoneTextView.text = employee["phone"].toString()
                depTextView.text = employee["department"].toString()
                descTextView.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                Glide.with(this)
                    .load(employee["image"])
                    .into(empImageView)
            }
        }
    }
}