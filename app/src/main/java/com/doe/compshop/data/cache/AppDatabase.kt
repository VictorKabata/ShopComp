package com.doe.compshop.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.doe.compshop.data.cache.dao.CartProductDao
import com.doe.compshop.data.cache.dao.ProductDao
import com.doe.compshop.data.cache.dao.UserDao
import com.doe.compshop.models.CartProduct
import com.doe.compshop.models.Product
import com.doe.compshop.models.User

@Database(entities = [User::class, Product::class, CartProduct::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun productDao(): ProductDao

    abstract fun cartProductDao():CartProductDao

}