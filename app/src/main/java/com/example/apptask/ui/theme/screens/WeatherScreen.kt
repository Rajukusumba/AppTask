package com.example.apptask.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apptask.ui.theme.viewmodels.WeatherViewModel
import com.example.apptask.ui.theme.customlayout.CustomAppBar

@SuppressLint("RememberReturnType", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherScreen(navController: NavController, viewModel: WeatherViewModel = WeatherViewModel()) {

    val weatherData = viewModel.weatherData.observeAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchWeather(12.9082847623315, 77.65197822993314)
    }
    val onLogoutClick = {
        // Handle logout logic here
        // For example, navigate to the login screen
        navController.navigate("login") // Ensure "LoginScreen" route is defined in your NavHost
    }

    Scaffold(
        topBar = {
            CustomAppBar(
                title = "My App Title",
                onClick ={ navController.popBackStack() } , logOut = onLogoutClick
            )
        },

        content = {
            Column(modifier = Modifier.padding(16.dp,30.dp)

                ) {
                Spacer(modifier = Modifier.height(80.dp))
              //  viewModel.fetchWeather(12.9082847623315, 77.65197822993314)
                if (weatherData != null) {
                    Text(text = "Temperature: ${weatherData.value?.daily?.get(0)?.temp}°F")
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "weather : ${weatherData.value?.current?.weather?.get(0)}°F")
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Humidity: ${weatherData.value?.current?.humidity}°F")
                    Spacer(modifier = Modifier.height(20.dp))
                } else {
                    Text(text = "No Data...")
                }
            }
        }
    )



}

//@Preview
//@Composable
//fun WeatherScreenPreview() {
//    val viewModel = WeatherViewModel()
//    WeatherScreen(viewModel)
//}

