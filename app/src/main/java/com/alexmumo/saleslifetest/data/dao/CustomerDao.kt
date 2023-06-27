package com.alexmumo.saleslifetest.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.saleslifetest.data.entity.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveCustomer(customer: Customer)
    @Query("SELECT * FROM customer_table")
    fun getCustomers(): LiveData<List<Customer>>
    @Query("DELETE FROM customer_table")
    suspend fun deleteCustomer()
}