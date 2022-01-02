package com.anushka.coroutinesdemo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserDataManager2 : ViewModel() {

    fun getUserData(){
        viewModelScope.launch{

        }
    }

}