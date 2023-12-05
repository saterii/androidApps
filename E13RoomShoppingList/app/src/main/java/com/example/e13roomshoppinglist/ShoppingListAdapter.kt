package com.example.e13roomshoppinglist
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingListAdapter (var shoppingList: MutableList<ShoppingListItem>)
    : RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ShoppingListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }
    inner class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val countTextView: TextView = view.findViewById(R.id.countTextView)
        val priceTextView: TextView = view.findViewById(R.id.priceTextView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // item to bind UI
        val item: ShoppingListItem = shoppingList[position]
        // name, count, price
        holder.nameTextView.text = item.name
        holder.countTextView.text = item.count.toString()
        holder.priceTextView.text = item.price.toString()
    }
    override fun getItemCount(): Int = shoppingList.size
    fun update(newList: MutableList<ShoppingListItem>) {
        shoppingList = newList
        notifyDataSetChanged()
    }
}