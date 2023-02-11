package com.hamza.task.model

import com.hamza.task.base.BaseEntity

data class Sports (
    val football: List<EventData>,
    val cricket: List<EventData>,
    val golf: List<EventData>
): BaseEntity()