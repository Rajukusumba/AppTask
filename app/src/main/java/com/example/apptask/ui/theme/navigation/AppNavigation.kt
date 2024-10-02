package com.example.applaunchwork.ui.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apptask.ui.theme.screens.WeatherScreen


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "OnboardingScreen") {
                composable("OnboardingScreen") { OnboardingScreen(navController) }
                composable("login") { LoginScreen(navController) }
                composable("userList") { UserListScreen(navController) }
                composable("userForm") { UserForm(navController) }
                composable("WeatherScreen") { WeatherScreen(navController) }

            }
        }






