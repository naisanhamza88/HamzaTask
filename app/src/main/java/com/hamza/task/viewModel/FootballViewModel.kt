package com.hamza.task.viewModel

import com.hamza.task.adapter.FootballAdapter
import com.hamza.task.base.BaseBindingFragment.Companion.appActivity
import com.hamza.task.base.BaseEntity
import com.hamza.task.base.BaseViewModel
import com.hamza.task.database.FootballEventData
import com.hamza.task.model.EventData

class FootballViewModel : BaseViewModel() {

    val footballAdapter = FootballAdapter(appActivity)

    fun fetchData() {
        requestHandler.fetchData(this)
    }

    override fun onSuccess(response: List<BaseEntity>, service: String) {
        super.onSuccess(response, service)
        response as List<EventData>
        saveOnDb(response)

        footballAdapter.updateList(response)
    }

    private fun saveOnDb(response: List<EventData>) {
        dataBaseHelper.footballDbDao().clearTable()
        response.forEach { item ->
            val data = FootballEventData(
                stadium = item.stadium,
                ID = 0,
                country = item.country,
                region = item.region,
                tournament = item.tournament,
                start = item.start,
                match = item.match
            )
            dataBaseHelper.footballDbDao().insertData(data)
        }
    }
}