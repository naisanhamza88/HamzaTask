package com.hamza.task.database

import android.content.Context
import androidx.room.Room
import javax.inject.Singleton

/**
 * Created by Hamza Abdullah on 1/28/2020.
 */

@Singleton
class DataBaseHelper private constructor() {

    val roomDatabase: FootballDataBase

    private object Holder {
        val INSTANCE = DataBaseHelper()
    }


    init {
        roomDatabase = Room.databaseBuilder(
            appContext!!,
            FootballDataBase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .addMigrations(FootballDataBase.MIGRATION_1_30)
            .build()
    }


    companion object {
        private const val DATABASE_NAME = "FootballDataBase.sqlite"
        private var appContext: Context? = null

        fun init(context: Context): DataBaseHelper {
            appContext = context
            return Holder.INSTANCE
        }
    }
}