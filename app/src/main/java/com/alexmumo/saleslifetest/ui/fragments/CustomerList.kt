package com.alexmumo.saleslifetest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.alexmumo.saleslifetest.R
import com.alexmumo.saleslifetest.adapter.CustomerAdapter
import com.alexmumo.saleslifetest.data.db.CustomerDatabase
import com.alexmumo.saleslifetest.data.entity.Customer
import com.alexmumo.saleslifetest.databinding.FragmentCustomerListBinding
import com.alexmumo.saleslifetest.repository.CustomerRepository
import com.alexmumo.saleslifetest.ui.viewmodel.CustomerViewModel
import com.alexmumo.saleslifetest.ui.viewmodel.CustomerViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class CustomerList : Fragment() {
    private lateinit var binding: FragmentCustomerListBinding
    private lateinit var customerViewModel: CustomerViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val customerDatabase = CustomerDatabase.getCustomerDatabase(requireActivity())
        val customerRepository = CustomerRepository(customerDatabase)
        val viewModelFactory = CustomerViewModelFactory(customerRepository)
        customerViewModel = ViewModelProvider(this, viewModelFactory)[CustomerViewModel::class.java]
        binding = FragmentCustomerListBinding.inflate(inflater, container, false)

        val customerAdapter = CustomerAdapter()
        customerViewModel.customers.observe(viewLifecycleOwner) {
            customerAdapter.submitList(it)
        }
        binding.customerRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.customerRecyclerView.adapter = customerAdapter

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_customerList_to_addCustomer)
        }

        return binding.root

    }
}