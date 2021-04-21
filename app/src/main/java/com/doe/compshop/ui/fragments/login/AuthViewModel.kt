package com.doe.compshop.ui.fragments.login

import android.util.Log
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.doe.compshop.models.User
import com.doe.compshop.repository.AuthRepository
import com.doe.compshop.util.Constants.TAG
import com.doe.compshop.util.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AuthViewModel @ViewModelInject constructor(private val authRepository: AuthRepository) :
    ViewModel(), Observable {

    var stateListener: StateListener? = null

    @Bindable
    val firstName = MutableLiveData<String>()

    @Bindable
    val lastName = MutableLiveData<String>()

    @Bindable
    val emailAddress = MutableLiveData<String>()

    @Bindable
    val phoneNumber = MutableLiveData<String>()

    @Bindable
    val password = MutableLiveData<String>()

    fun loginUser(view: View) {
        stateListener?.onLoading()

        if (emailAddress.value.isNullOrEmpty()) {
            stateListener?.onError("Enter email address")
            return
        } else if (password.value.isNullOrEmpty()) {
            stateListener?.onError("Enter password")
            return
        }


        viewModelScope.launch {
            try {
                val loginResponse = authRepository.loginUser(emailAddress.value!!, password.value!!)

                loginResponse.collect { user ->
                    if (user == null) {
                        stateListener?.onError("User account not found")
                        return@collect
                    } else {
                        stateListener?.onSuccess("Welcome, ${user.firstName} ${user.lastName}")

                        authRepository.setUserLoggedIn()

                        return@collect
                    }
                }
            } catch (e: Exception) {
                stateListener?.onError(e.message!!)
                return@launch
            }
        }
    }

    fun registerUser(view: View) {
        when {
            firstName.value.isNullOrEmpty() -> {
                stateListener?.onError("Enter first name")
                return
            }
            lastName.value.isNullOrEmpty() -> {
                stateListener?.onError("Enter last name")
                return
            }
            emailAddress.value.isNullOrEmpty() -> {
                stateListener?.onError("Enter email address")
                return
            }
            phoneNumber.value.isNullOrEmpty() -> {
                stateListener?.onError("Enter phone number")
                return
            }
            password.value.isNullOrEmpty() -> {
                stateListener?.onError("Enter password")
                return
            }
        }

        viewModelScope.launch {
            try {
                val user = User(
                    0,
                    firstName.value!!,
                    lastName.value!!,
                    emailAddress.value!!,
                    phoneNumber.value!!,
                    password.value!!
                )

                authRepository.registerUser(user)

                stateListener?.onSuccess("Welcome, ${firstName.value} ${lastName.value}")

                authRepository.setUserLoggedIn()

                return@launch
            } catch (e: Exception) {
                stateListener?.onError(e.message!!)
                return@launch
            }
        }

    }

    fun isUserLoggedIn() = liveData {
        val isUserLoggedIn = authRepository.isUserLoggedIn()

        Log.e(TAG, "isUserLoggedIn viewModel: isUserLoggedIn: $isUserLoggedIn")

        emit(isUserLoggedIn)
        return@liveData
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
}