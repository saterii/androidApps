package com.example.e07myfirstappwithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val textBox = view.findViewById<TextView>(R.id.textView)
        val args = this.arguments
        val displayText = args?.getString("displayText")
        textBox.text = displayText.toString()
        return view
    }
}