package com.example.room

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.room.ui.feedlist.FeedListFragment
import com.example.room.ui.feedinput.InputFragment

class MainPagerAdapter(fragmentManager: FragmentManager, a: Int) :
    FragmentStatePagerAdapter(fragmentManager, a) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        if(position == 0){
            return InputFragment.newInstance()
        }
        else{
            return FeedListFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if(position == 0)
            return "INPUT"
        else
            return "LIST"
    }
}