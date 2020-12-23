package com.example.room

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.repository.FeedRepository
import com.example.room.room.Feed
import kotlinx.coroutines.launch

class InputViewModel constructor(val feedRepository: FeedRepository) : ViewModel() {
    val feedId = MutableLiveData<String?>()
    val userId = MutableLiveData<String?>()
    val userName = MutableLiveData<String?>()
    val profilePicUri = MutableLiveData<String?>()
    val reviewUris = MutableLiveData<ArrayList<Uri>?>()
    val likeCount = MutableLiveData<String?>()
    val restaurantName = MutableLiveData<String?>()
    val review = MutableLiveData<String?>()
    val rating = MutableLiveData<Float?>()

    fun saveFeed() {
        viewModelScope.launch {
            var feed = Feed()
            feed.review_id = feedId.value.toString().toInt()
            feed.userName = userName.value
            feed.restaurantName = restaurantName.value
            feedRepository.saveFeed(feed)
        }
    }
}