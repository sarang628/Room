package com.example.room.ui.feedlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.room.R
import com.example.room.databinding.FeedListFragmentBinding
import com.example.room.repository.DatabaseProvider
import com.example.room.repository.ViewModelFactory
import com.example.room.room.Feed

class FeedListFragment : Fragment(), FeedClickableFragment {

    private var onFeedClickListener: OnFeedClickListener? = null

    companion object {
        fun newInstance() = FeedListFragment()
    }

    private lateinit var viewModel: FeedListViewModel
    private lateinit var mBinding: FeedListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feed_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FeedListFragmentBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModelFactory = ViewModelFactory(DatabaseProvider.getInstance(context!!))
        viewModel = ViewModelProvider(this, viewModelFactory).get(FeedListViewModel::class.java)
        mBinding.rvFeed.adapter = FeedRvAdt(viewModel)
        viewModel.feeds.observe(viewLifecycleOwner, Observer {
            Log.d("__sarang", "observe!")
            (mBinding.rvFeed.adapter as FeedRvAdt).setFeeds(it as ArrayList<Feed>)
        })

        viewModel.selectedFeed.observe(viewLifecycleOwner, Observer {
            onFeedClickListener?.onFeedClick(it)
        })
    }

    override fun setOnFeedClickListener(onFeedClickListener: OnFeedClickListener) {
        this.onFeedClickListener = onFeedClickListener
    }
}