package com.example.room.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Feed::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
