package com.example.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room.repository.FeedRepository
import com.example.room.room.Feed

class FeedListViewModel constructor(private val feedRepository: FeedRepository) : ViewModel() {
    val feeds : LiveData<List<Feed>> = feedRepository.appDatabase.userDao().getAll()
}