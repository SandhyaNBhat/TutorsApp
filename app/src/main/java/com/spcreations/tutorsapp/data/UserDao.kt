package com.spcreations.tutorsapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    //Queries to interact with User table
    @Insert
    suspend fun createUser(user:User)

    @Query("SELECT count(user_name) FROM User where user_email=:email and password=:pwd")
    fun verifyLogin(email:String,pwd:String): LiveData<Int>

    //Queries for Batch table

    @Insert
    suspend fun createBatch(batch:Batch)

    //Queries for Student table

    @Insert
    suspend fun createStudent(student: Student)





}