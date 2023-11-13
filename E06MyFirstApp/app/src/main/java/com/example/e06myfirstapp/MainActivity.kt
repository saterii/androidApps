package com.example.e06myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun switchActivity(view: View){
        val displayText = findViewById<EditText>(R.id.editText1).text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("text", displayText)
        startActivity(intent);
    }
}