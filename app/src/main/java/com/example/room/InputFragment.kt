package com.example.room

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.room.databinding.InputFragmentBinding
import com.example.room.repository.DatabaseProvider
import com.example.room.repository.ViewModelFactory

class InputFragment : Fragment() {

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
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModelFactory = ViewModelFactory(DatabaseProvider.getInstance(context!!))
        viewModel = ViewModelProvider(this, viewModelFactory).get(InputViewModel::class.java)
        mBinding.vm = viewModel
    }

}