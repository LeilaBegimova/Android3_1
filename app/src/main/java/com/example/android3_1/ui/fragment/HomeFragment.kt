package com.example.android3_1.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android3_1.R
import com.example.android3_1.databinding.FragmentHomeBinding
import com.example.android3_1.ui.data.PreferensHelper
import com.example.android3_1.ui.data.model.HomeViewModel
import com.example.android3_1.ui.data.model.Model


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserves()
        setupListeners()
    }

    private fun initialize() {
        val preferensHelper = PreferensHelper(requireActivity())
        homViewModel.updateUserModel(
            Model(
                preferensHelper.username!!,
                preferensHelper.userage!!,
                preferensHelper.useremail!!,
                preferensHelper.userpassword!!
            )
        )
    }

    private fun setupObserves() {
        homViewModel.userData.observe(viewLifecycleOwner) { userData ->
            binding.tvUserData.text = userData.name
            binding.tvData.text = userData.age
            binding.teData.text = userData.email
            binding.atData.text = userData.password
        }
    }

    private fun setupListeners() {
        binding.btnGoEdit.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_redactorFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}