package com.doe.compshop.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.doe.compshop.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM `User Table` WHERE Email=:email AND Password=:password")
    fun loginUser(email: String, password: String): Flow<User?>

    @Query("SELECT * FROM `User Table`")
    fun getUserDetails(): Flow<User>

    @Query("DELETE FROM `User Table`")
    suspend fun logOutUser()

}