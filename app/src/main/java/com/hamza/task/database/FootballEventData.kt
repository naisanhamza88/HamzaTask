package com.hamza.task.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hamza.task.base.BaseEntity

@Entity(tableName = "FootballEventData")
data class FootballEventData(

    @SerializedName("ID")
    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    var ID: Int?,

    @SerializedName("stadium")
    @ColumnInfo(name = "stadium")
    val stadium: String?,

    @SerializedName("country")
    @ColumnInfo(name = "country")
    val country: String?,

    @SerializedName("region")
    @ColumnInfo(name = "region")
    val region: String?,

    @SerializedName("tournament")
    @ColumnInfo(name = "tournament")
    val tournament: String?,

    @SerializedName("start")
    @ColumnInfo(name = "start")
    val start: String?,

    @SerializedName("match")
    @ColumnInfo(name = "match")
    val match: String?

) : BaseEntity()