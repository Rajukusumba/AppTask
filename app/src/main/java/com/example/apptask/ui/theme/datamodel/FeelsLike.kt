package com.example.apptask.ui.theme.datamodel


import com.google.gson.annotations.SerializedName


data class FeelsLike(
    @SerializedName("day")
    var day: Double?,
    @SerializedName("eve")
    var eve: Double?,
    @SerializedName("morn")
    var morn: Double?,
    @SerializedName("night")
    var night: Double?
)