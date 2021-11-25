package com.example.demo004.network

import com.example.demo004.model.User
import com.example.demo004.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface PunkApiSevice {
    @GET("?results=50")
    fun getAllUsers(): Call<Users>
}