package com.example.learnviewmodel2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(val startValue : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startValue) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}