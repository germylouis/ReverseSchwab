package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.db.UserDatabase
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.repository.UserRepository
import com.example.myapplication.viewmodel.UserViewModel
import com.example.myapplication.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userViewModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = UserDatabase.getInstance(application).userDAO
        val repository = UserRepository(dao)
        val factory  = UserViewModelFactory(repository)
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        binding.myViewModel = userViewModel
        binding.lifecycleOwner = this
    }

}
