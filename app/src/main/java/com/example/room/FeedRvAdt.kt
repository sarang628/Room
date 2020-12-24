package com.example.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.room.Feed

class FeedRvAdt : RecyclerView.Adapter<FeedVH>() {
    private var feeds = ArrayList<Feed>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
        return FeedVH(view)
    }

    override fun onBindViewHolder(holder: FeedVH, position: Int) {
        holder.setFeed(feeds[position]);

    }

    override fun getItemCount(): Int {
        return feeds.size
    }

    fun setFeeds(list : ArrayList<Feed>){
        feeds = list
        notifyDataSetChanged()
    }

}