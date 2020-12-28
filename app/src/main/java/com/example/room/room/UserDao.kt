package com.example.room.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM Feed")
    fun getAll(): LiveData<List<Feed>>

    /*@Query("SELECT * FROM Feed WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Feed>*/

    /*@Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Feed*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg feeds: Feed)

    @Delete
    suspend fun delete(user: Feed)
}