package com.doe.compshop.ui.fragments.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doe.compshop.models.User
import com.doe.compshop.repository.AuthRepository
import com.doe.compshop.util.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val authRepository: AuthRepository) :
    ViewModel() {

    var stateListener: StateListener? = null

    private val _loggedInUser = MutableLiveData<User>()
    val loggedInUser = _loggedInUser

    init {
        getLoggedInUser()
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

}