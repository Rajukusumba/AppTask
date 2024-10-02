package com.example.applaunchwork.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apptask.ui.theme.customlayout.AppLaunchText


@Composable
fun OnboardingScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        AppLaunchText()
        Spacer(modifier = Modifier.padding(vertical = 80.dp))
        
        Text(text = "Welcome to the Weather App!")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("login")
        }) {
            Text("Login")
        }
    }
}