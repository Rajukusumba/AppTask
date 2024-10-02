package com.example.applaunchwork.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apptask.ui.theme.database.UserEntity
import com.example.apptask.ui.theme.viewmodels.UserFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserForm(navController: NavController, viewModel: UserFormViewModel = UserFormViewModel()) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    TopAppBar(
        title = {
            Text(
                text = "User Form",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary // Customize the AppBar color if needed
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = firstName, onValueChange = { firstName = it }, label = { Text("First Name") })
        Spacer(modifier = Modifier.padding(top = 10.dp))
        TextField(value = lastName, onValueChange = { lastName = it }, label = { Text("Last Name") })
        Spacer(modifier = Modifier.padding(top = 10.dp))
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })

        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty()) {
                    viewModel.addUser(UserEntity(firstName = firstName, lastName = lastName, email = email))
                    navController.navigate("userList")
                }
            }) {
                Text("Save")
            }
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Button(onClick = { navController.navigate("userList") }) {
                Text("Cancel")
            }
        }
    }
}
