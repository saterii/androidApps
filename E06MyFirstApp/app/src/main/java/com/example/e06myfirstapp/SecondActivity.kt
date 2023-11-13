package com.example.e06myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras;
        if (bundle!= null){
            val text1 = bundle!!.getString("text")
            findViewById<TextView>(R.id.textView2).setText(text1);
        }
    }
    fun goBack(view: View){
        finish()
    }
}