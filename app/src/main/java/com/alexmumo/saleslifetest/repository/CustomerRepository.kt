package com.alexmumo.saleslifetest.repository

import com.alexmumo.saleslifetest.data.dao.CustomerDao
import com.alexmumo.saleslifetest.data.db.CustomerDatabase
import com.alexmumo.saleslifetest.data.entity.Customer


class CustomerRepository(private val customerDatabase: CustomerDatabase) {

    fun getCustomers() = customerDatabase.customerDao().getCustomers()

    suspend fun saveCustomer(customer: Customer) {
        customerDatabase.customerDao().saveCustomer(customer)
    }
}