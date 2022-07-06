package com.example.hw2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw2.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase :RoomDatabase() {
abstract fun historyDao(): HistoryDao


}