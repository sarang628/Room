package com.example.room.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.InputViewModel
import com.example.room.room.AppDatabase

class ViewModelFactory constructor(val appDatabase: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InputViewModel(FeedRepository(appDatabase)) as T
    }
}