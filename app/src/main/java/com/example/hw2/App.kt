package com.example.hw2

import android.app.Application
import com.example.hw2.model.LoveApi
import com.example.hw2.model.RetrofitServic

class App: Application() {
companion object{
    lateinit var loveApi: LoveApi

}

    override fun onCreate() {
        super.onCreate()
        val retrofitServic = RetrofitServic()
        loveApi = retrofitServic.getApi()
    }
}