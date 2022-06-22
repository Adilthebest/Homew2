package com.example.hw2

import android.app.Application

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