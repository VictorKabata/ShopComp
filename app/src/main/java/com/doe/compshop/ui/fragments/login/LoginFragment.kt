package com.doe.compshop.ui.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.doe.compshop.R
import com.doe.compshop.databinding.FragmentLoginBinding
import com.doe.compshop.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(), StateListener {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<AuthViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.viewModel = viewModel
        viewModel.stateListener = this

        //Navigate to register fragment
        binding.linearLayoutRegister.setOnClickListener {
            findNavController().navigate(R.id.login_to_registration)
        }


        return binding.root
    }

    override fun onLoading() {
        binding.progressBarLogin.show()
    }

    override fun onSuccess(message: String?) {
        binding.progressBarLogin.hide()

        requireActivity().toast(message!!)
        requireActivity().log(message)

        findNavController().navigate(R.id.login_to_home) //Navigate to home fragment upon successful login
    }

    override fun onError(message: String) {
        binding.progressBarLogin.hide()

        requireActivity().toast(message)
        requireActivity().log(message)
    }
}