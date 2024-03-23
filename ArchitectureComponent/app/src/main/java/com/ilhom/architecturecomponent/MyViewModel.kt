package com.ilhom.architecturecomponent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var counter = 0

    private val mutableCounterLiveData = MutableLiveData<Int>()
    val counterLiveData: LiveData<Int> = mutableCounterLiveData
    fun increment() {
        counter++
        mutableCounterLiveData.value = counter
    }

}