package com.example.e07myfirstappwithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val btn = view.findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val editText = view.findViewById<EditText>(R.id.editText1)
            val input = editText.text.toString()
            val bundle = Bundle()
            bundle.putString("displayText", input)
            val fragment = SecondFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment, fragment)?.commit()
        }
        return view
    }

}