package com.hamza.task.network

import com.hamza.task.model.Sports
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiAccount {

    @GET("sports.json")
    fun fetchData(
        @Query("q") city: String,
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
    ): Observable<Sports>

}