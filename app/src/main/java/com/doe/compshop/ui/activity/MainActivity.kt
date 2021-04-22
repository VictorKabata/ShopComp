package com.doe.compshop.ui.activity

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.doe.compshop.R
import com.doe.compshop.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home_fragment -> {
                    binding.bottomNav.visibility = VISIBLE
                }
                R.id.cart_fragment -> {
                    binding.bottomNav.visibility = VISIBLE
                }
                else -> {
                    binding.bottomNav.visibility = GONE
                }
            }
        }

        binding.bottomNav.setupWithNavController(navController)
    }

    private fun initUI() {

    }
}