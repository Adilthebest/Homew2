package com.example.hw2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw2.model.LoveModel
import com.example.hw2.repository.Repository

class LoveViewModel :ViewModel() {
    val repository = Repository()

    fun getLiveLoveViewModel ( firstName: String,
                               secondName: String):LiveData<LoveModel>{
        return  repository.getMutableLiveDataOfLoveData(firstName,secondName)
    }
}