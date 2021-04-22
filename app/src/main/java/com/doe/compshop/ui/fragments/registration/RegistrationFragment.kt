package com.doe.compshop.ui.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.doe.compshop.R
import com.doe.compshop.databinding.FragmentRegistrationBinding
import com.doe.compshop.ui.fragments.login.AuthViewModel
import com.doe.compshop.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment(), StateListener {

    private lateinit var binding: FragmentRegistrationBinding
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_registration, container, false)
        binding.viewModel = viewModel
        viewModel.stateListener = this

        binding.linearLayoutLogin.setOnClickListener {
            it.findNavController().navigateUp()
        }


        return binding.root
    }

    override fun onLoading() {
        binding.progressBarRegister.show()
    }

    override fun onSuccess(message: String?) {
        binding.progressBarRegister.hide()

        requireActivity().toast(message!!)
        requireActivity().log(message)

        findNavController().navigate(R.id.registration_to_home) //Navigate to home fragment upon successful registration
    }

    override fun onError(message: String) {
        binding.progressBarRegister.hide()

        if (isAdded){
            requireActivity().toast(message)
            requireActivity().log(message)
        }

    }
}