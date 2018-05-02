package com.skywalker.architecture.livedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

class NameViewModel:ViewModel() {
    val currentName = lazy {
        return@lazy MutableLiveData<String>()}

    fun test(){

    }
}