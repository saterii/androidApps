package com.example.e04sumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun numberInput(view: View){
        val result = findViewById<TextView>(R.id.resultView)
        try {
            if (result.text.toString().toInt() == 0){
                result.text = ""

            }else{
                result.text = result.text
            }
        }catch(ex: NumberFormatException){
            result.text = result.text
        }
        val digit = (view as Button).text.toString().toInt()
        result.append(digit.toString())
    }
    fun symbolInput(view: View){
        val result = findViewById<TextView>(R.id.resultView)
        try {
            if (result.text.toString().toInt() == 0){
                result.text = ""

            }else{
                result.text = result.text
            }
        }catch(ex: NumberFormatException){
            result.text = result.text
        }
        val digit = (view as Button).text.toString()
        result.append(digit)
    }
    fun displayResult(view: View){
        var sum: Int = 0
        val result = findViewById<TextView>(R.id.resultView)
        val numbers = result.text.split("+").toTypedArray()
        for(i in numbers){
            sum += i.toString().toInt()
        }
        result.append("=")
        result.append(sum.toString())
    }
    fun clearAll(view: View){
        findViewById<TextView>(R.id.resultView).text = "0"
    }
}