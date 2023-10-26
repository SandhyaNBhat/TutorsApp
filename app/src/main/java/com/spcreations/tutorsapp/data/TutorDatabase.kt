package com.spcreations.tutorsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class,Batch::class,Student::class),version=1, exportSchema = false)
abstract class TutorDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    //Create single instance of the database. If the database instance is available, use that else create it using databaseBuilder.
    companion object{
        @Volatile
        private var INSTANCE: TutorDatabase? = null

        fun getDatabase(context: Context): TutorDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TutorDatabase::class.java,
                    "tutor_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

}


}