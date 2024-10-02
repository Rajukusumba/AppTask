package com.example.apptask.ui.theme.datamodel


import com.google.gson.annotations.SerializedName


data class WeatherRes(
    @SerializedName("current")
    var current: Current?,
    @SerializedName("daily")
    var daily: List<Daily>?,
    @SerializedName("hourly")
    var hourly: List<Hourly>?,
    @SerializedName("lat")
    var lat: Double?,
    @SerializedName("lon")
    var lon: Double?,
    @SerializedName("minutely")
    var minutely: List<Minutely>?,
    @SerializedName("timezone")
    var timezone: String?,
    @SerializedName("timezone_offset")
    var timezoneOffset: Int?
)