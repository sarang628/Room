package com.example.room.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.ui.feedlist.FeedListViewModel
import com.example.room.ui.feedinput.InputViewModel
import com.example.room.room.AppDatabase

class ViewModelFactory constructor(val appDatabase: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InputViewModel::class.java)) {
            return InputViewModel(FeedRepository(appDatabase)) as T
        } else if (modelClass.isAssignableFrom(FeedListViewModel::class.java)) {
            return FeedListViewModel(FeedRepository(appDatabase)) as T
        }

        throw IllegalAccessException("unknown viewmodel class")
    }
}