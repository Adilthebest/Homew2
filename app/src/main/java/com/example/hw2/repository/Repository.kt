package com.example.hw2.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw2.model.LoveApi
import com.example.hw2.model.LoveModel
import com.example.hw2.room.AppDataBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor( private val api: LoveApi , private val dao:AppDataBase) {

    fun getMutableLiveDataOfLoveData(
        firstName: String,
        secondName: String
    ): MutableLiveData<LoveModel> {
        val liveLoveModel: MutableLiveData<LoveModel> = MutableLiveData()
/*
        dao.historyDao().getAll()
*/
        api.getPercentage(firstName, secondName).enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveLoveModel.postValue(it)

                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure:${t.message}")
            }
        })
        return liveLoveModel
    }

    fun getWeatherRoom() : LiveData<List<LoveModel>> {
        return dao.historyDao().getAll()
    }
}

