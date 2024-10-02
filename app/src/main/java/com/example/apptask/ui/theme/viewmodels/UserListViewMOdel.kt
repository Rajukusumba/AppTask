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


}
