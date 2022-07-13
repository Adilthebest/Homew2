package com.example.hw2

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class Prefs(context: Context) {

    var prefs: SharedPreferences = context.getSharedPreferences("setting", Context.MODE_PRIVATE)

    fun saveState() {
        prefs.edit().putBoolean("isShow", true).apply()
    }

    fun isShown(): Boolean {
        return prefs.getBoolean("isShown", false)

    }

}