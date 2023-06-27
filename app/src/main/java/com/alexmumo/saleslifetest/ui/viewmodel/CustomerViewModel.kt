package com.alexmumo.saleslifetest.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.saleslifetest.data.entity.Customer
import com.alexmumo.saleslifetest.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CustomerViewModel(private val customerRepository: CustomerRepository): ViewModel() {
    val customers = customerRepository.getCustomers()
    fun saveCustomer(customer: Customer) {
        viewModelScope.launch(Dispatchers.IO) {
            customerRepository.saveCustomer(customer)
        }
    }
}