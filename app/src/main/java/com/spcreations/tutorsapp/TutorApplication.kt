package com.spcreations.tutorsapp

import android.app.Application
import com.spcreations.tutorsapp.data.TutorDatabase

class TutorApplication: Application() {
    val database by lazy{ TutorDatabase.getDatabase(this) }
    val repository by lazy{TutorRepository(database.userDao())}
}