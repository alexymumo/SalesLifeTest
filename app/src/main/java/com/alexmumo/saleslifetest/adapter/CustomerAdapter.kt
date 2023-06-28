package com.alexmumo.saleslifetest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alexmumo.saleslifetest.R
import com.alexmumo.saleslifetest.data.entity.Customer
import com.alexmumo.saleslifetest.ui.fragments.CustomerList

class CustomerAdapter : ListAdapter<Customer, CustomerRecyclerViewHolder>(CustomerComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.customer_item,parent, false)
        return CustomerRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerRecyclerViewHolder, position: Int) {
        val customer = getItem(position)
        holder.firstname.text = customer.firstname
        holder.lastname.text = customer.lastname
        holder.surname.text = customer.surname
        holder.location.text = customer.location

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_customerList_to_customerLocation)
        }
    }
}

class CustomerRecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val firstname: TextView = itemView.findViewById(R.id.firstname)
    val surname: TextView = itemView.findViewById(R.id.secondname)
    val lastname: TextView = itemView.findViewById(R.id.lastname)
    val location: TextView = itemView.findViewById(R.id.location)
}

class CustomerComparator: DiffUtil.ItemCallback<Customer>() {
    override fun areItemsTheSame(oldItem: Customer, newItem: Customer): Boolean {
        return oldItem.customer_id == newItem.customer_id
    }

    override fun areContentsTheSame(oldItem: Customer, newItem: Customer): Boolean {
        return oldItem == newItem
    }
}
