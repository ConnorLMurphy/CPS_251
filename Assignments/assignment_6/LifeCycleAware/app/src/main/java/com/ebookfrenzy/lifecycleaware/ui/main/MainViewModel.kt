package com.ebookfrenzy.lifecycleaware.ui.main

import android.util.Log
import androidx.lifecycle.*

class MainViewModel : ViewModel() {


    companion object{
        private var sec: MutableLiveData<String> = MutableLiveData()


        fun addStates(Seconds: String){
                sec.value = sec.value + "\n" + Seconds


        }
    }

    fun getStates(): MutableLiveData<String>{

        return sec
    }
}