package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var names:MutableList<String> = mutableListOf("Aleksi", "Miikka", "Elias", "Henri", "Paavo", "Ville", "Otto")
    lateinit var adapter: namesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.namesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = namesAdapter(names)
        recyclerView.adapter = adapter
    }
    //Button event handling
    fun addClicked(view: View){
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val name: String = nameEditText.text.toString()
        names.add(name)
        adapter.notifyDataSetChanged()

    }
}
