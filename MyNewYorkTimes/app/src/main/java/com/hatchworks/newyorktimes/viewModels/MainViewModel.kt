package com.hatchworks.newyorktimes.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _testResponse = MutableLiveData<String>().apply {
        value = "Welcome to the new york times app"
    }
    val testResponse: LiveData<String> = _testResponse


 
}