package com.example.hw2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love_model")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
val id:Int,
    @SerializedName("fname")
    val firstname:String,
    @SerializedName("sname")
    val secondname:String,
    val percentage:String,
    val result:String
)
