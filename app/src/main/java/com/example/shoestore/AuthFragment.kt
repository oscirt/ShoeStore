package com.example.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {
    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_auth, container, false)

        binding.buttonLogin.setOnClickListener{
            findNavController().navigate(R.id.action_authFragment_to_helloFragment)
        }
        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_helloFragment)
        }

        return binding.root
    }
}