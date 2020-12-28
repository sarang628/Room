package com.example.room.repository

import com.example.room.room.AppDatabase
import com.example.room.room.Feed

class FeedRepository constructor(val appDatabase: AppDatabase) {
    val userDao = appDatabase.userDao()
    suspend fun saveFeed(feed: Feed){
        userDao.insertAll(feed)
    }

    suspend fun deleteFeed(feed: Feed) {
        userDao.delete(feed)
    }
}