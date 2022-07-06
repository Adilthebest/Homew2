package com.example.hw2

import android.content.Context

class Prefs ( context: Context) {
    var preferences = context.getSharedPreferences("setting", Context.MODE_PRIVATE)
    fun saveState() {
        preferences.edit().putBoolean("isShow", true).apply()
    }

    fun isShown(): Boolean {
        return preferences.getBoolean("isShown", false)

    }

}