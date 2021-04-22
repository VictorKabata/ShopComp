package com.doe.compshop.ui.fragments.cart

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doe.compshop.models.CartProduct
import com.doe.compshop.repository.CartRepository
import com.doe.compshop.util.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CartViewModel @ViewModelInject constructor(private val cartRepository: CartRepository) :
    ViewModel() {

    var stateListener: StateListener? = null

    private val _cartProducts = MutableLiveData<MutableList<CartProduct>>()
    val cartProducts = _cartProducts

    init {
        getCartProducts()
    }

    private fun getCartProducts() {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                cartRepository.getCartProducts().collect { cartProducts ->
                    _cartProducts.value = cartProducts
                }
                stateListener?.onSuccess("Fetched cart products")
                return@launch
            } catch (e: Exception) {
                stateListener?.onError("${e.message}")
                return@launch
            }
        }
    }

    fun clearCart() {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                cartRepository.clearCart()
                stateListener?.onSuccess("Items bought")
                return@launch
            } catch (e: Exception) {
                stateListener?.onError(e.message!!)
                return@launch
            }
        }
    }

}