package com.example.myapplication.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.User
import com.example.myapplication.domain.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val users = repository.users

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputPassword = MutableLiveData<String>()

    @Bindable
    val loginButton = MutableLiveData<String>()


    init {
        loginButton.value = "Log In"
    }

    fun login() {
        val name = inputName.value!!
        val password = inputPassword.value!!
        insert(User(0,name,password))
        inputName.value = null
        inputPassword.value = null

    }

    fun insert(user: User) = viewModelScope.launch { repository.insert(user) }

    fun update(user: User) = viewModelScope.launch { repository.delete(user) }

    fun deleteAll() = viewModelScope.launch { repository.deleteAll() }

}