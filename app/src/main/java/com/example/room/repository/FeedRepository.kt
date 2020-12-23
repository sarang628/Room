package com.example.room.repository

import com.example.room.room.AppDatabase
import com.example.room.room.Feed

class FeedRepository constructor(val appDatabase: AppDatabase) {
    suspend fun saveFeed(feed: Feed){
        appDatabase.userDao().insertAll(feed)
    }
}