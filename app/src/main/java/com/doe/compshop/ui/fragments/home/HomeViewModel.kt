package com.doe.compshop.ui.fragments.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doe.compshop.models.Product
import com.doe.compshop.models.User
import com.doe.compshop.repository.AuthRepository
import com.doe.compshop.repository.ProductRepository
import com.doe.compshop.util.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository,
    private val productRepository: ProductRepository
) :
    ViewModel() {

    var stateListener: StateListener? = null

    private val _loggedInUser = MutableLiveData<User>()
    val loggedInUser = _loggedInUser

    /*private val _monitors = MutableLiveData<List<Product>>()
    val monitors = _monitors

    private val _processors = MutableLiveData<List<Product>>()
    val processors = _processors

    private val _graphicCards = MutableLiveData<List<Product>>()
    val graphicCards = _graphicCards

    private val _storage = MutableLiveData<List<Product>>()
    val storage = _storage*/

    private val _products = MutableLiveData<List<Product>>()
    val products = _products


    init {
        getLoggedInUser()
        getProducts()
    }

    private fun getLoggedInUser() {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                val userResponse = authRepository.getLoggedInUser()
                userResponse.collect { user ->
                    _loggedInUser.value = user
                }

                stateListener?.onSuccess("Fetched logged in user")
                return@launch
            } catch (e: Exception) {
                stateListener?.onError(e.message!!)
                return@launch
            }
        }
    }

    private fun getProducts() {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                productRepository.getProducts().collect { products ->
                    _products.value = products
                }
                stateListener?.onSuccess("Fetched products")
                return@launch
            } catch (e: Exception) {
                stateListener?.onError(e.message!!)
                return@launch
            }
        }

    }

}