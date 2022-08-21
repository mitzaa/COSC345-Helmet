package com.example.culturle

import android.content.Context

class PreferenceManager() {

    fun getValue(targetKey:String, context : Context) : Int{
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        return preference.getInt(targetKey, 0)
    }

    fun setPreference(targetKey:String, newValue:Int, context : Context) {
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putInt(targetKey, newValue)
        editor.apply()
    }
}