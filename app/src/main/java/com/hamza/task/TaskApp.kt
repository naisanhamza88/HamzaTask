package com.hamza.task

import android.app.Application

class TaskApp : Application() {


    companion object {
        private lateinit var mInstance: TaskApp
    }


    @Synchronized
    fun getInstance(): TaskApp {
        return mInstance
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this

    }


    fun getBaseURL(): String {
        return "https://weatherapi-com.p.rapidapi.com/"
    }
}


