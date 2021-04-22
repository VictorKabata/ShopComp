package com.doe.compshop.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.doe.compshop.models.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(products: MutableList<Product>)

    @Query("SELECT * FROM `Product Table`")
    fun getProducts(): Flow<MutableList<Product>>

    @Query("SELECT COUNT(*) FROM `Product Table`")
    suspend fun isProductCacheAvailable(): Int

}