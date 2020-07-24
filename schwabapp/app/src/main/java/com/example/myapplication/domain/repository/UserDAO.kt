package com.example.myapplication.domain.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.domain.model.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM User")
    suspend fun deleteAll()

    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<User>>
}