package com.spcreations.tutorsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val user_name: String,
    val user_email: String,
    val password: String
)

@Entity
data class Batch(
    @PrimaryKey(autoGenerate = true) val batch_id: Int=0,
    val batch_name: String,
    val course_name: String,
    val classes_per_week: Int,
    val days_of_week: String,
    val start_time: String,
    val end_time: String,
    val course_fee: Int
)

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)val student_id: Int =0,
    val student_name :String,
    val age: Int,
    val parent_name:String,
    val batch_id:Int,
    val contact_num:Int,
    val email: String,
    val fee_amount:Int
)