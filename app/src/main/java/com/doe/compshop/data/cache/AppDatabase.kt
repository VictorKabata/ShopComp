package com.doe.compshop.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.doe.compshop.data.cache.dao.ProductDao
import com.doe.compshop.data.cache.dao.UserDao
import com.doe.compshop.models.Product
import com.doe.compshop.models.User

@Database(entities = [User::class, Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun productDao(): ProductDao

}