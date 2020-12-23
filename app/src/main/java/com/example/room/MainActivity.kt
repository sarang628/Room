package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.room.room.AppDatabase
import com.example.room.room.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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