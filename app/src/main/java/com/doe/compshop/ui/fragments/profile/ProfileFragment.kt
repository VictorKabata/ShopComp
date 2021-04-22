package com.doe.compshop.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.doe.compshop.R
import com.doe.compshop.databinding.FragmentProfileBinding
import com.doe.compshop.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(), StateListener {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<ProfileViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        viewModel.stateListener = this

        binding.buttonSignOut.setOnClickListener {
            viewModel.logOutUser()

            findNavController().navigate(R.id.profile_to_login)
        }

        binding.imageViewBack.setOnClickListener { findNavController().navigateUp() }

        initUI()

        return binding.root
    }

    private fun initUI() {
        viewModel.loggedInUser.observe(viewLifecycleOwner, { user ->
            val username = "${user.firstName!!} ${user.lastName!!}"

            binding.textViewUsername.text = username
            binding.textViewEmail.text = user.email
            binding.textViewPhone.text = user.phoneNumber

        })
    }

    override fun onLoading() {
        binding.progressBarProfile.show()
    }

    override fun onSuccess(message: String?) {
        binding.progressBarProfile.hide()

        requireActivity().log(message!!)
    }

    override fun onError(message: String) {
        binding.progressBarProfile.hide()

        if (isAdded) {
            requireActivity().toast(message)
            requireActivity().log(message)
        }
    }

}