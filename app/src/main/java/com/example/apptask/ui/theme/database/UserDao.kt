package com.example.apptask.ui.theme.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Insert
    fun insertUser(user: UserEntity)

    @Query("DELETE FROM users WHERE id = :userId")
    fun deleteUserById(userId: Int)
}