package com.spcreations.tutorsapp

import androidx.lifecycle.LiveData
import com.spcreations.tutorsapp.data.Batch
import com.spcreations.tutorsapp.data.Student
import com.spcreations.tutorsapp.data.User
import com.spcreations.tutorsapp.data.UserDao
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

class TutorRepository(private val tutorDao: UserDao) {

    suspend fun insertUser(user: User){
        tutorDao.createUser(user)
    }
    suspend fun insertBatch(batch: Batch){
        tutorDao.createBatch(batch)
    }
    suspend fun insertStudent(student: Student){
        tutorDao.createStudent(student)
    }

     fun verifyLogin(email:String,password:String): LiveData<Int> {
        return tutorDao.verifyLogin(email,password)
    }
}