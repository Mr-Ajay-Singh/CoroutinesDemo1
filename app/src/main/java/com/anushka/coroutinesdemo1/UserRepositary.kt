package com.anushka.coroutinesdemo1

import kotlinx.coroutines.delay

class UserRepositary {

    suspend fun getUsers() : List<String>{
        delay(1000)
        var list : List<String> = listOf(
            "Hello",
            "World",
            "How Are",
            "You"
        )
        return list
    }

}