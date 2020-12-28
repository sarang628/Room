package com.example.room.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.room.MainPagerAdapter
import com.example.room.databinding.ActivityMainBinding
import com.example.room.room.Feed
import com.example.room.ui.feedlist.FeedClickableFragment
import com.example.room.ui.feedlist.OnFeedClickListener

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    private var mFeedClickListener: OnFeedClickListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.vp.adapter = MainPagerAdapter(supportFragmentManager, 0)

        mBinding.tabLayout.setupWithViewPager(mBinding.vp)

        Thread(Runnable {
//            db.userDao().insertAll(User(1,"사랑", "양"))
//            db.userDao().insertAll(User(2,"a", "b"))
//            db.userDao().insertAll(User(3,"사랑", "양"))
//            db.userDao().insertAll(User(4,"사랑", "양"))


//            Log.d("__sarang", "${db.userDao().getAll().size}")

        }).start()
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is FeedClickableFragment)
            fragment.setOnFeedClickListener(object : OnFeedClickListener {
                override fun onFeedClick(feed: Feed) {
                    mFeedClickListener?.onFeedClick(feed)
                    mBinding.vp.setCurrentItem(0, true)
                }
            })

        if (fragment is OnFeedClickListener) {
            mFeedClickListener = fragment
        }
    }
}