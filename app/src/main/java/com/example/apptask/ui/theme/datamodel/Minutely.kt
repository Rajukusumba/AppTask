package com.example.apptask.ui.theme.datamodel


import com.google.gson.annotations.SerializedName


data class Minutely(
    @SerializedName("dt")
    var dt: Int?,
    @SerializedName("precipitation")
    var precipitation: Int?
)