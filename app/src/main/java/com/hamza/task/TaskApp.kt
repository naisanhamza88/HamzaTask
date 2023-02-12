package com.hamza.task

import android.app.Application
import com.facebook.FacebookSdk

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
        FacebookSdk.setApplicationId("945042406866198")
        FacebookSdk.setClientToken("9396a222781bff27c89bf080d1617ecf")
        FacebookSdk.sdkInitialize(this)

    }


    fun getBaseURL(): String {
        return "https://weatherapi-com.p.rapidapi.com/"
    }
}


