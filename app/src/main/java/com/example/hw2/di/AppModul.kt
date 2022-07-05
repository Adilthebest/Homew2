package com.example.hw2.di

import android.content.Context
import com.example.hw2.MainActivity
import com.example.hw2.model.LoveApi
import com.example.hw2.Prefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)


    }

    @Provides
    fun providePrefs(prefs: Prefs): Prefs {
return prefs

    }

}


















