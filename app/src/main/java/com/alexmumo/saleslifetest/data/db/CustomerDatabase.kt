package com.alexmumo.saleslifetest.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexmumo.saleslifetest.data.dao.CustomerDao
import com.alexmumo.saleslifetest.data.entity.Customer

@Database(
    entities = [Customer::class],
    exportSchema = false,
    version = 3
)
abstract class CustomerDatabase: RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {
        @Volatile
        private var INSTANCE: CustomerDatabase? = null

        fun getCustomerDatabase(context: Context): CustomerDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!

        }

        private fun buildDatabase(context: Context): CustomerDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CustomerDatabase::class.java,
                "customer.db"
            ).fallbackToDestructiveMigration().build()
        }
    }
}