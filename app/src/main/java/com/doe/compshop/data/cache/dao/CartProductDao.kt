package com.doe.compshop.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.doe.compshop.models.CartProduct
import com.doe.compshop.models.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface CartProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProductToCart(cartProduct: CartProduct)

    @Query("SELECT * FROM `Cart Table`")
    fun getCartProducts(): Flow<MutableList<CartProduct>>

    @Query("DELETE FROM `Cart Table`")
    suspend fun clearCart()

}