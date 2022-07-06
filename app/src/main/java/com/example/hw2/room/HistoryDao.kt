package com.example.hw2.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hw2.model.LoveModel

@Dao
interface HistoryDao {
    @Insert
    fun insert(model:LoveModel)
    @Query("SELECT * FROM love_model ORDER BY firstname ASC")
    fun getAll():LiveData<List<LoveModel>>

}