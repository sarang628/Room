package com.example.room.ui.feedinput

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imagepciker.ImagePicker
import com.example.room.R
import com.example.room.databinding.InputFragmentBinding
import com.example.room.repository.DatabaseProvider
import com.example.room.repository.ViewModelFactory
import com.example.room.room.Feed
import com.example.room.ui.feedlist.FeedClickableFragment
import com.example.room.ui.feedlist.OnFeedClickListener

class InputFragment : Fragment() , OnFeedClickListener {

    val imagePicker = ImagePicker.newInstance()

    companion object {
        fun newInstance() = InputFragment()
    }

    private lateinit var viewModel: InputViewModel
    private lateinit var mBinding : InputFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = InputFragmentBinding.bind(view)
        mBinding.lifecycleOwner = viewLifecycleOwner

        mBinding.btnFindProfile.setOnClickListener {
            imagePicker.actionOpenDocument(this){
                mBinding.ivProfile.setImageBitmap(it)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModelFactory = ViewModelFactory(DatabaseProvider.getInstance(context!!))
        viewModel = ViewModelProvider(this, viewModelFactory).get(InputViewModel::class.java)
        mBinding.vm = viewModel
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.let { imagePicker.onActivityResult(requestCode, resultCode, it, context!!) }
    }

    override fun onFeedClick(feed: Feed) {
        viewModel.setFeed(feed)
    }
}