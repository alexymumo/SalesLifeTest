package com.alexmumo.saleslifetest.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexmumo.saleslifetest.repository.CustomerRepository
import kotlin.IllegalArgumentException


@Suppress("UNCHECKED_CAST")
class CustomerViewModelFactory(private val customerRepository: CustomerRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CustomerViewModel::class.java)) {
            return CustomerViewModel(customerRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
        //return super.create(modelClass)
    }
}