package com.hamza.task.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Hamza Abdullah on 1/29/2020.
 */

@Dao
interface FootballDbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(model: FootballEventData)

    @Query("DELETE FROM FootballEventData")
    fun clearTable()

    @Query("SELECT * FROM FootballEventData ")
    fun getData(): List<FootballEventData>


}