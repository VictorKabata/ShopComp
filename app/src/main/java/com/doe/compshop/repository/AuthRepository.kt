package com.doe.compshop.repository

import com.doe.compshop.data.cache.AppDatabase
import com.doe.compshop.data.datastore.AuthDataStore
import com.doe.compshop.models.User
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val appDatabase: AppDatabase,
    private val authDataStore: AuthDataStore
) {

    fun getUserDetails() = appDatabase.userDao().getUserDetails()

    fun loginUser(email: String, password: String)=appDatabase.userDao().loginUser(email, password)

    suspend fun registerUser(user: User) = appDatabase.userDao().registerUser(user)

    suspend fun logOutUser() = appDatabase.userDao().logOutUser()

    suspend fun setUserLoggedIn() = authDataStore.loginUser()

    suspend fun isUserLoggedIn() = authDataStore.isUserLoggedIn()

    suspend fun setUserLoggedOut() = authDataStore.loginUser()

}