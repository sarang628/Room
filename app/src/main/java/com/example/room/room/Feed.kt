package com.example.room.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Feed(
    @PrimaryKey
    var review_id: Int = -1,
    var isFavority: Boolean = false,
//    var pictures: ArrayList<Picture?>? = null
//    var medias: ArrayList<AdMedia?>? = null,
//    var restaurant: Restaurant? = null,
//    var user: UserVO? = null,
    var likeCount: String? = null,
    var userId: String? = null,
    var userName: String? = null,
    var restaurantName: String? = null,
    var contents: String? = null,
    var create_date: String? = null,
    var rating: Float? = 3f,
    var profilePicUri: String? = null
//    var like: Like? = null
)