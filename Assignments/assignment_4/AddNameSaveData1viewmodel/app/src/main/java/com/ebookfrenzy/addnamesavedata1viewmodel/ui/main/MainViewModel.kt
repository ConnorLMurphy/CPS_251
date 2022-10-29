package com.ebookfrenzy.addnamesavedata1viewmodel.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var names = ""

    fun addName (name:String){
        this.names = this.names + "\n" + name

    }

    fun getName ():String{
        return names
    }




}