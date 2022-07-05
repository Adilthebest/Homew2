package com.example.hw2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw2.model.LoveModel
import com.example.hw2.repository.Repository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) :ViewModel() {

    fun getLiveLoveViewModel ( firstName: String,
                               secondName: String):LiveData<LoveModel>{
        return repository.getMutableLiveDataOfLoveData(firstName,secondName)
    }
}