package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.room.databinding.ActivityMainBinding
import com.example.room.room.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vp.adapter = MainPagerAdapter(supportFragmentManager, 0)

        binding.tabLayout.setupWithViewPager(binding.vp)

        val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
        ).build()

        Thread(Runnable {
//            db.userDao().insertAll(User(1,"사랑", "양"))
//            db.userDao().insertAll(User(2,"a", "b"))
//            db.userDao().insertAll(User(3,"사랑", "양"))
//            db.userDao().insertAll(User(4,"사랑", "양"))


//            Log.d("__sarang", "${db.userDao().getAll().size}")

        }).start()


    }
}