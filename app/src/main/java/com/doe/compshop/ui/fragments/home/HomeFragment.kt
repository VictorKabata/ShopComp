package com.doe.compshop.ui.fragments.home

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
import com.doe.compshop.databinding.FragmentHomeBinding
import com.doe.compshop.models.Product
import com.doe.compshop.ui.adapters.ProductsRecyclerViewAdapter
import com.doe.compshop.util.Constants.GRAPHIC_CARDS
import com.doe.compshop.util.Constants.MONITORS
import com.doe.compshop.util.Constants.PROCESSORS
import com.doe.compshop.util.Constants.STORAGE
import com.doe.compshop.util.OnClick
import com.doe.compshop.util.StateListener
import com.doe.compshop.util.log
import com.doe.compshop.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), StateListener, OnClick {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.imageViewProfile.setOnClickListener {
            it.findNavController().navigate(R.id.home_to_profile)
        }

        binding.editTextSearch.setOnClickListener { requireActivity().toast("Feature is under development") }

        initUI()

        return binding.root
    }

    private fun initUI() {
        viewModel.loggedInUser.observe(viewLifecycleOwner, { user ->
            val username = "${user.firstName!!} ${user.lastName!!}"
            binding.textViewUsername.text = username
        })

        viewModel.products.observe(viewLifecycleOwner, { products ->
            binding.recyclerviewMonitors.adapter =
                ProductsRecyclerViewAdapter(products, MONITORS, this)

            binding.recyclerviewProcessors.adapter =
                ProductsRecyclerViewAdapter(products, PROCESSORS, this)

            binding.recyclerviewGraphicCards.adapter =
                ProductsRecyclerViewAdapter(products, GRAPHIC_CARDS, this)

            binding.recyclerviewStorage.adapter =
                ProductsRecyclerViewAdapter(products, STORAGE, this)
        })

    }

    override fun onClick(product: Product) {
        val action = HomeFragmentDirections.homeToDetails(product)
        findNavController().navigate(action)
    }

    override fun onLoading() {

    }

    override fun onSuccess(message: String?) {
        requireActivity().log(message!!)
    }

    override fun onError(message: String) {

        requireActivity().toast(message)
        requireActivity().log(message)
    }

}