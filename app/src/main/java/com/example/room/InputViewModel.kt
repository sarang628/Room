package com.example.room

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputViewModel : ViewModel() {
    val userId = MutableLiveData<String?>()
    val userName = MutableLiveData<String?>()
    val profilePicUri = MutableLiveData<String?>()
    val reviewUris = MutableLiveData<ArrayList<Uri>?>()
    val likeCount = MutableLiveData<String?>()
    val restaurantName = MutableLiveData<String?>()
    val review = MutableLiveData<String?>()
    val rating = MutableLiveData<Float?>()
}