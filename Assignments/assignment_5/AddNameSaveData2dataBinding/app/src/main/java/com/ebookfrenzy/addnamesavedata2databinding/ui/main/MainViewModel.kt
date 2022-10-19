package com.ebookfrenzy.addnamesavedata2databinding.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    var nameInput: MutableLiveData<String> = MutableLiveData()
    var names: MutableLiveData<String> = MutableLiveData()

    fun addName (){
        nameInput.let {
            if (!it.value.equals("")) {
                if(!names.value.equals(null)){
                    names.value = names.value + "\n" + nameInput.value
                }else{
                    names.value = nameInput.value
                }


            } else {
                names.value = names.value
            }
        }
    }




}