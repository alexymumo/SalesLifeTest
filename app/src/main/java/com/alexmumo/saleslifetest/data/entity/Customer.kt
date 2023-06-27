package com.alexmumo.saleslifetest.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    val customer_id: Int,
    val firstname: String,
    val surname: String,
    val lastname: String,
    val latitude: Double?,
    val longitude: Double?
)
