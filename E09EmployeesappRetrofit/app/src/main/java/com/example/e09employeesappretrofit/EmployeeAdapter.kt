package com.example.e09employeesappretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EmployeeAdapter(
    private var employees: List<Employee>,
    private val itemClickListener: (Employee) -> Unit
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_item, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        holder.bind(employee)
        holder.itemView.setOnClickListener {
            itemClickListener(employee)
        }
    }

    override fun getItemCount(): Int = employees.size

    fun updateData(newEmployees: List<Employee>) {
        employees = newEmployees
        notifyDataSetChanged()
    }

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        private val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val depTextView: TextView = itemView.findViewById(R.id.depTextView)
        private val employeeImageView: ImageView = itemView.findViewById(R.id.employeeImageView)
        fun bind(employee: Employee) {
            nameTextView.text = "${employee.firstName} ${employee.lastName}"
            emailTextView.text = employee.email
            phoneTextView.text = employee.phone
            titleTextView.text = employee.title
            depTextView.text = employee.department
            Glide.with(itemView.context)
                .load(employee.image)
                .into(employeeImageView)
        }
    }
}