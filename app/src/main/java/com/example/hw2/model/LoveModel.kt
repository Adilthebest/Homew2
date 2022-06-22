package com.example.hw2.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

data class LoveModel(
    @SerializedName("fname")
    val firstname:String,
    @SerializedName("sname")
    val secondname:String,
    val persenteg:String,
    val result:String
)
