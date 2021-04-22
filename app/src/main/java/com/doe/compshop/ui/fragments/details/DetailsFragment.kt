package com.doe.compshop.ui.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.doe.compshop.R
import com.doe.compshop.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        binding.toolbarDetails.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }

        initUI()

        return binding.root
    }

    private fun initUI() {
        val product = args.product!!

        Glide.with(requireActivity()).load(R.drawable.ic_launcher_background)
            .into(binding.imageViewDetails)

        binding.textViewProductName.text = product.name
        binding.textViewProductPrice.text = product.price
        binding.textViewProductDescription.text = product.description
        binding.textViewProductSpec.text = product.spec
        binding.textViewProductModel.text = product.modelNumber

        if (product.inStock) binding.textViewProductStock.text = "Available"
        else binding.textViewProductStock.text = "Not Available"

    }
}