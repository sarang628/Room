package com.example.room

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.room.databinding.ItemFeedBinding
import com.example.room.room.Feed
import com.example.room.ui.feedlist.FeedListViewModel

class FeedVH(itemView: View, feedListViewModel: FeedListViewModel) : RecyclerView.ViewHolder(itemView) {
    private var mBinding : ItemFeedBinding = ItemFeedBinding.bind(itemView)
    init {
        mBinding.vm = feedListViewModel
    }
    fun setFeed(feed: Feed) {
        mBinding.feed = feed
    }
}