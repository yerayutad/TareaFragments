package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Result(
    @Expose
    val cell: String,
    @Expose
    val email: String,
    @Expose
    val gender: String,
    @Expose
    val nat: String,
    @Expose
    val phone: String,
)