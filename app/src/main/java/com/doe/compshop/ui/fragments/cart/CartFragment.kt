package com.doe.compshop.ui.fragments.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.doe.compshop.R
import com.doe.compshop.databinding.FragmentCartBinding
import com.doe.compshop.models.Product
import com.doe.compshop.ui.adapters.CartRecyclerViewAdapter
import com.doe.compshop.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment(), StateListener, OnClick {

    private lateinit var binding: FragmentCartBinding
    private val viewModel by viewModels<CartViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        viewModel.stateListener = this

        binding.buttonAddToCart.setOnClickListener {
            viewModel.clearCart()
        }

        initUI()

        return binding.root
    }

    private fun initUI() {
        viewModel.cartProducts.observe(viewLifecycleOwner, { cartProducts ->
            if (cartProducts.isNullOrEmpty()) binding.buttonAddToCart.visibility = View.GONE

            var totalValue = 0.0
            cartProducts.forEach { cartProduct ->
                totalValue += cartProduct.price
            }

            totalValue.toFloat()
            binding.buttonAddToCart.text = "USD $totalValue"

            binding.recyclerviewCart.adapter = CartRecyclerViewAdapter(cartProducts, this)

        })
    }

    override fun onClick(product: Product) {
        val action = CartFragmentDirections.cartToDetails(product)
        findNavController().navigate(action)
    }

    override fun onLoading() {
        binding.progressBarCart.show()
    }

    override fun onSuccess(message: String?) {
        binding.progressBarCart.hide()

        if (isAdded) {
            requireActivity().log(message!!)
            requireActivity().toast(message)
        }
    }

    override fun onError(message: String) {
        binding.progressBarCart.hide()

        if (isAdded) {
            requireActivity().log(message)
            requireActivity().toast(message)
        }
    }

}