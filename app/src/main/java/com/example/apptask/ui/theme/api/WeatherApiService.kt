package com.example.apptask.ui.theme.api

import com.example.apptask.ui.theme.datamodel.WeatherRes
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("onecall")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") apiKey: String
    ): WeatherRes
}