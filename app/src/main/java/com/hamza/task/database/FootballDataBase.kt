package com.hamza.task.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Created by Hamza Abdullah on 1/28/2020.
 */

@Database(
    entities = [FootballEventData::class],
    version = 1,
    exportSchema = false
)

abstract class FootballDataBase : RoomDatabase() {

    abstract fun footballDbDao(): FootballDbDao

    companion object {
        @JvmField
        val MIGRATION_1_30: Migration = object : Migration(1, 30) {
            override fun migrate(database: SupportSQLiteDatabase) {
            }
        }

    }


}