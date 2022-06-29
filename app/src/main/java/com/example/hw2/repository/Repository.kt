package com.example.hw2.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hw2.App
import com.example.hw2.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    fun getMutableLiveDataOfLoveData(
        firstName: String,
        secondName: String
    ): MutableLiveData<LoveModel> {
        val liveLoveModel : MutableLiveData<LoveModel> = MutableLiveData()
        App.loveApi.getPercentage(firstName, secondName).enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        liveLoveModel?.postValue(it)

                    }
}
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
Log.e("ololo","onFailure:${t.message}")
            }
        })
        return liveLoveModel
    }
}
