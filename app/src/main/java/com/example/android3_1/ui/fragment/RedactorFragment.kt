package com.example.android3_1.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android3_1.R
import com.example.android3_1.databinding.FragmentRedactorBinding
import com.example.android3_1.databinding.FragmentRegisrationBinding
import com.example.android3_1.ui.data.PreferensHelper

class RedactorFragment : Fragment() {
    private var _binding: FragmentRedactorBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRedactorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListenners()
    }

    private fun setupListenners() = with(binding) {
        btnSing.setOnClickListener {
            val preferensHelper = PreferensHelper(requireActivity())
            preferensHelper.username = etName.text.toString().trim()
            preferensHelper.userage = tvAge.text.toString().trim()
            preferensHelper.useremail = etEmail.text.toString().trim()
            preferensHelper.userpassword = etPassword.text.toString().trim()
            findNavController().navigateUp()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}