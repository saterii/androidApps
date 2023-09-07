package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class namesAdapter(private val names: MutableList<String>) :
    RecyclerView.Adapter<namesAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.nameTextView.text = names[position]
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.name_item, viewGroup, false)

        return ViewHolder(view)
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView

        init {
            // Define click listener for the ViewHolder's View
            nameTextView = view.findViewById(R.id.nameTextView)
        }
    }
    override fun getItemCount() = names.size
}