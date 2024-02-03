package com.example.android3_1.ui.Registration

import android.graphics.ColorSpace.Model
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android3_1.R
import com.example.android3_1.databinding.FragmentRegisrationBinding
import com.example.android3_1.ui.data.PreferensHelper

class RegisrationFragment : Fragment() {
    private var _binding: FragmentRegisrationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListenners()
    }

    private fun setupListenners() = with(binding) {
        btnSingIn.setOnClickListener {
            val preferensHelper = PreferensHelper(requireActivity())
            preferensHelper.username = etUserName.text.toString().trim()
            preferensHelper.userage = etAge.text.toString().trim()
            preferensHelper.useremail = etUserEmail.text.toString().trim()
            preferensHelper.userpassword = etUserPassword.text.toString().trim()
            preferensHelper.register = true
            findNavController().navigate(R.id.action_regisrationFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


