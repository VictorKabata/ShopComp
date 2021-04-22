package com.doe.compshop.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.doe.compshop.data.cache.AppDatabase
import com.doe.compshop.models.Product
import com.doe.compshop.util.Constants.TAG
import com.doe.compshop.util.Coroutines
import com.doe.compshop.util.Seeder
import javax.inject.Inject

class ProductRepository @Inject constructor(private val appDatabase: AppDatabase) {

    private val _productsMutableLiveData = MutableLiveData<MutableList<Product>>()

    init {

        Coroutines.io { fetchProducts() }

        _productsMutableLiveData.observeForever { products ->
            Coroutines.io { saveProducts(products) }
        }

    }

    //Simulates a network call
    private suspend fun fetchProducts() {
        val isProductsCacheAvailable = appDatabase.productDao().isProductCacheAvailable() > 0

        if (!isProductsCacheAvailable) {
            val productsResponse = Seeder().fetchProducts()

            Log.e(TAG, "fetchProducts repository: Products table is null ")

            _productsMutableLiveData.postValue(productsResponse)
        } else return

    }

    //Save the "response" from "network call" to SQLite
    private suspend fun saveProducts(products: MutableList<Product>) =
        appDatabase.productDao().saveProducts(products)

    //Retrieves products stored in SQLite
    fun getProducts() = appDatabase.productDao().getProducts()

}