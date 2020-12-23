package com.example.room.repository

import android.content.Context
import androidx.room.Room
import com.example.room.room.AppDatabase

class DatabaseProvider {
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null)
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "database-name"
                ).build()

            return INSTANCE!!
        }
    }
}