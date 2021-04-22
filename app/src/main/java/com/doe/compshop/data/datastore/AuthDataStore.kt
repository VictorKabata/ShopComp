package com.doe.compshop.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.doe.compshop.util.Constants.AUTH_DATASTORE_KEY
import com.doe.compshop.util.Constants.AUTH_DATASTORE_NAME
import kotlinx.coroutines.flow.first

class AuthDataStore constructor(private val context: Context) {

    private val Context.dataStore by preferencesDataStore(name = AUTH_DATASTORE_NAME)

    //Marks the user as logged in
    suspend fun loginUser() {
        val dataStoreKey = booleanPreferencesKey(AUTH_DATASTORE_KEY)
        context.dataStore.edit {
            it[dataStoreKey] = true
        }
    }

    //Checks if the user is logged in
    suspend fun isUserLoggedIn(): Boolean {
        val dataStoreKey = booleanPreferencesKey(AUTH_DATASTORE_KEY)
        val loginStatus = context.dataStore.data.first()

        return loginStatus[dataStoreKey]  ?: false //If null return false else return value in datastore
    }

    //Marks the user as logged out
    suspend fun logOutUser() {
        val dataStoreKey = booleanPreferencesKey(AUTH_DATASTORE_KEY)
        context.dataStore.edit { token ->
            token[dataStoreKey] = false
        }
    }


}