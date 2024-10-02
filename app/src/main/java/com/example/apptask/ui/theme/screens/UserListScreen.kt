package com.example.applaunchwork.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput

import com.example.apptask.ui.theme.database.UserEntity
import com.example.apptask.ui.theme.viewmodels.UserListViewMOdel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserListScreen(navController: NavController, viewModel: UserListViewMOdel = UserListViewMOdel() ) {

    val userList by viewModel.userList.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Users List")
                },
                actions = {
                    // Add button for adding a new user
                    IconButton(onClick = {
                        // Navigate to User Form when button is clicked
                        navController.navigate("userForm")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add User"
                        )
                    }
                }
            )

        },

    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                 .padding(top = 85.dp)
        ) {


                items(userList, key = { it.id }) { user ->
                    var dismissed by remember { mutableStateOf(false) }

                    if (!dismissed) {
                        SwipeableUserItem(
                            user = user,
                            onDismiss = {
                                dismissed = true
                                viewModel.removeUser(user) // Remove from the list
                            },
                            onClick = {
                                navController.navigate("WeatherScreen")
                            }
                        )
                    }
                }
            }
        }
            }



@Composable
fun SwipeableUserItem(user: UserEntity, onDismiss: () -> Unit, onClick: () -> Unit) {
    var offsetX by remember { mutableStateOf(0f) }
    val maxOffsetX = 300f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .offset(x = offsetX.dp)
             .background(Color(0xFFADD8E6))
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragEnd = {

                        if (offsetX > maxOffsetX) {
                            onDismiss()
                        } else {

                            offsetX = 0f
                        }
                    }
                ) { _, dragAmount ->
                    offsetX += dragAmount
                }
            }
    ) {
        UserItem(user = user, onClick = onClick)
    }



}

@Composable
fun UserItem(user: UserEntity, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.Start

    ) {
        BasicText(
            text = "${user.firstName} ${user.lastName}",
            style = MaterialTheme.typography.titleMedium
        )
        BasicText(text = user.email, style = MaterialTheme.typography.bodySmall)
    }
}


