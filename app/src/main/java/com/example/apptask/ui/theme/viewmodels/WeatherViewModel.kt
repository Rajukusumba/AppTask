package com.example.apptask.ui.theme.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptask.ui.theme.api.RetrofitInstance
import com.example.apptask.ui.theme.datamodel.WeatherRes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel:ViewModel() {

    private val apiKey = "b143bb707b2ee117e62649b358207d3e" // Use your actual API key


    private var _weatherData = MutableLiveData<WeatherRes?>()
    val weatherData: LiveData<WeatherRes?>
        get() = _weatherData
    init {
        fetchWeather(12.9082847623315, 77.65197822993314)

    }
    fun fetchWeather(lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var weatherData1 =
                    RetrofitInstance.retrofit.getWeather(lat, lon, "imperial", apiKey)
                _weatherData.postValue(weatherData1)

            } catch (e: Exception) {
                e.printStackTrace()
                _weatherData.value = null

            }
        }

    }
}