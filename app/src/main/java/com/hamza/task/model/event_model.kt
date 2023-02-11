package com.hamza.task.model

import com.hamza.task.base.BaseEntity

data class EventData(
    val stadium: String,
    val country: String,
    val region: String,
    val tournament: String,
    val start: String,
    val match: String
): BaseEntity()