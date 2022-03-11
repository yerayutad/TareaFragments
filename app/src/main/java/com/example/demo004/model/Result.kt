package com.example.demo004.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @Expose
    @SerializedName("name")
    val cell: String,
    @Expose
    @SerializedName("email")
    val email: String,
    @Expose
    @SerializedName("genero")
    val gender: String,
    @Expose
    @SerializedName("nat")
    val nat: String,
    @Expose
    @SerializedName("tlf")
    val phone: String,
)