package com.example.room

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.room.databinding.ItemFeedBinding
import com.example.room.room.Feed

class FeedVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mBinding : ItemFeedBinding
    init {
        mBinding = ItemFeedBinding.bind(itemView)
    }
    fun setFeed(feed: Feed) {
        mBinding.feed = feed
    }
}