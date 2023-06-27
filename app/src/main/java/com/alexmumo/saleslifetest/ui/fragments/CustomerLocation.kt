package com.alexmumo.saleslifetest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alexmumo.saleslifetest.R
import com.alexmumo.saleslifetest.databinding.FragmentCustomerLocationBinding

class CustomerLocation : Fragment() {

    private lateinit var binding: FragmentCustomerLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomerLocationBinding.inflate(layoutInflater)
        return binding.root
    }
}