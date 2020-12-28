package com.example.room.ui.feedinput

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
    val likeCount = MutableLiveData<String?>().apply {
        value = "1"
    }
    val restaurantName = MutableLiveData<String?>().apply {
        value = "starbucks"
    }
    val review = MutableLiveData<String?>().apply {
        value = "good"
    }
    val rating = MutableLiveData<Float?>()

    fun saveFeed() {
        viewModelScope.launch {
            var feed = Feed()
            feed.review_id = feedId.value.toString().toInt()
            feed.userId = feed.userId
            feed.userName = userName.value
            feed.likeCount = likeCount.value
            feed.restaurantName = restaurantName.value
            feed.rating = rating.value
            feed.contents = review.value
            feedRepository.saveFeed(feed)
        }
    }

    fun deleteFeed() {
        viewModelScope.launch {
            var feed = Feed()
            feed.review_id = feedId.value.toString().toInt()
            feedRepository.deleteFeed(feed)
        }
    }

    fun setFeed(feed: Feed) {
        feedId.value = feed.review_id.toString()
        userName.value = feed.userName
        userId.value = feed.userId
        likeCount.value = feed.likeCount
        rating.value = feed.rating
        restaurantName.value = feed.restaurantName
        review.value = feed.contents

    }
}