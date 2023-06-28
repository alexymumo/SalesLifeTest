package com.alexmumo.saleslifetest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alexmumo.saleslifetest.R
import com.alexmumo.saleslifetest.data.db.CustomerDatabase
import com.alexmumo.saleslifetest.data.entity.Customer
import com.alexmumo.saleslifetest.databinding.FragmentAddCustomerBinding
import com.alexmumo.saleslifetest.repository.CustomerRepository
import com.alexmumo.saleslifetest.ui.viewmodel.CustomerViewModel
import com.alexmumo.saleslifetest.ui.viewmodel.CustomerViewModelFactory

class AddCustomer : Fragment() {
    private lateinit var binding: FragmentAddCustomerBinding;
    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCustomerBinding.inflate(inflater, container, false)
        val customerDatabase = CustomerDatabase.getCustomerDatabase(requireActivity())
        val customerRepository = CustomerRepository(customerDatabase)
        val viewModelFactory = CustomerViewModelFactory(customerRepository)
        customerViewModel = ViewModelProvider(this, viewModelFactory)[CustomerViewModel::class.java]

        binding.customerBtn.setOnClickListener {
            val firstname = binding.firstname.text.toString()
            val surname = binding.surname.text.toString()
            val lastname = binding.lastname.text.toString()
            val location = binding.location.text.toString()

            when {
                firstname.isEmpty() -> {
                    binding.firstname.error = "Cannot be empty"
                }
                lastname.isEmpty() -> {
                    binding.lastname.error = "Cannot be empty"
                }
                location.isEmpty() -> {
                    binding.location.error = "Cannot be empty"
                }
                surname.isEmpty() -> {
                    binding.surname.error = "Cannot be empty"
                } else -> {
                    customerViewModel.saveCustomer(Customer(0, firstname,surname, lastname, location))
                    Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_addCustomer_to_customerList)
                }
            }
        }

        return binding.root
    }
}