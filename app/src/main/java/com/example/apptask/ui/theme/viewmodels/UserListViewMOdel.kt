package com.example.apptask.ui.theme.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applaunchwork.ui.theme.Graph
import com.example.apptask.ui.theme.database.UserEntity
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserListViewMOdel():ViewModel() {
    private val _userList = MutableStateFlow<List<UserEntity>>(emptyList())
    val userList = _userList.asStateFlow()



    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch (Dispatchers.IO){
            _userList.value= Graph.db.userDao().getAllUsers()
        }
    }
    fun removeUser(use: UserEntity){
        viewModelScope.launch (Dispatchers.IO){
            Graph.db.userDao().deleteUserById(userId = use.id)
        }
    }
    fun getUsers() {

//            val users = AppDatabase.getDatabase(context =).userDao().getAllUsers()
//            _userList.value = users
            // Handle users list
       // }
    }
//    private fun addDummyData() {
//        // Adding dummy data for testing
//        val dummyUsers = listOf(
//            UserEntity(firstName = "John", lastName = "Doe", email = "john.doe@example.com"),
//            UserEntity(firstName = "Jane", lastName = "Smith", email = "jane.smith@example.com"),
//            UserEntity(firstName = "Emily", lastName = "Jones", email = "emily.jones@example.com"),
//            UserEntity(
//                firstName = "Michael",
//                lastName = "Brown",
//                email = "michael.brown@example.com"
//            ),
//            UserEntity(firstName = "Sarah", lastName = "Davis", email = "sarah.davis@example.com")
//        )
//        _userList.value = dummyUsers // Update the user list with dummy data
//    }
}
