package com.doe.compshop.ui.fragments.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doe.compshop.models.CartProduct
import com.doe.compshop.models.Product
import com.doe.compshop.repository.CartRepository
import com.doe.compshop.util.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsViewModel @ViewModelInject constructor(private val cartRepository: CartRepository) :
    ViewModel() {

    var stateListener: StateListener? = null


    fun saveProductToCart(product:Product) {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                cartRepository.saveProductToCart(product)

                stateListener?.onSuccess("Saved to cart")
                return@launch
            } catch (e: Exception) {
                stateListener?.onError("${e.message}")
                return@launch
            }
        }
    }


}