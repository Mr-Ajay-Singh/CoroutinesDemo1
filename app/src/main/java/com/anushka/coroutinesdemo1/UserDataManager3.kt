package com.anushka.coroutinesdemo1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDataManager3 : ViewModel() {

    var liveData = liveData(Dispatchers.IO){
        val result = UserRepositary().getUsers()
        emit(result)
    }

//    var liveData : MutableLiveData<List<String>> = MutableLiveData()
//    lateinit var mainList : List<String>
//    fun getUserData(){
//        viewModelScope.launch{
//            withContext(IO){
//                var list : List<String>? = null
//                list = UserRepositary().getUsers()
//                mainList = list
//            }
//            liveData.value = mainList
//        }
//    }

}