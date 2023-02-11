package com.hamza.task.view

import android.os.Bundle
import com.hamza.task.R
import com.hamza.task.base.BaseActivity
import com.hamza.task.view.football_view.FootballFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.main_container, FootballFragment())
            .addToBackStack("WeatherFragment").commit()
    }
}