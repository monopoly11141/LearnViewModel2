package com.example.learnviewmodel2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModel(val startValue : Int) : ViewModel() {

    private var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
    get() = total

    init {
        total.value = startValue
    }

    fun add(number : Int){
        total.value = total.value?.plus(number)
    }

}