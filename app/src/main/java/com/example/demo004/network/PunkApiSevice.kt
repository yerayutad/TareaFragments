package com.example.demo004.network

import com.example.demo004.model.User
import com.example.demo004.model.Users
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PunkApiSevice {
    @GET("?results=50")
    fun getAllUsers(): Call<Users>
    @GET("?gender=")
    fun getAllGender(s: String): Call<Users>
    @POST("users")
    fun addUser(@Body userData: User): Call<Users>
}