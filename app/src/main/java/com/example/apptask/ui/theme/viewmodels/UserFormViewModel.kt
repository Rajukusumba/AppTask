package com.example.apptask.ui.theme.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.applaunchwork.ui.theme.Graph.db
import com.example.apptask.ui.theme.database.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserFormViewModel:ViewModel() {

    fun addUser(user: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
           db?.userDao()?.insertUser(user)
        }
    }


}