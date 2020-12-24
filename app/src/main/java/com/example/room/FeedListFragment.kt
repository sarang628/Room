package com.example.room

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.room.databinding.FeedListFragmentBinding
import com.example.room.repository.DatabaseProvider
import com.example.room.repository.ViewModelFactory
import com.example.room.room.Feed

class FeedListFragment : Fragment() {
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
        mBinding.rvFeed.adapter = FeedRvAdt()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModelFactory = ViewModelFactory(DatabaseProvider.getInstance(context!!))
        viewModel = ViewModelProvider(this, viewModelFactory).get(FeedListViewModel::class.java)

        viewModel.feeds.observe(viewLifecycleOwner, Observer {
            Log.d("__sarang", "observe!")
            (mBinding.rvFeed.adapter as FeedRvAdt).setFeeds(it as ArrayList<Feed>)
        })
    }

}