package com.doe.compshop.repository

import com.doe.compshop.data.cache.AppDatabase
import com.doe.compshop.mappers.toCartProduct
import com.doe.compshop.models.Product
import javax.inject.Inject

class CartRepository @Inject constructor(private val appDatabase: AppDatabase) {

    suspend fun saveProductToCart(product: Product) =
        appDatabase.cartProductDao().saveProductToCart(product.toCartProduct())

    fun getCartProducts() = appDatabase.cartProductDao().getCartProducts()

    suspend fun clearCart() = appDatabase.cartProductDao().clearCart()

}