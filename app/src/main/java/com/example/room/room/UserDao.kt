package com.example.room.room

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM Feed")
    fun getAll(): List<Feed>

    /*@Query("SELECT * FROM Feed WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Feed>*/

    /*@Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Feed*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg feeds: Feed)

    @Delete
    fun delete(user: Feed)
}