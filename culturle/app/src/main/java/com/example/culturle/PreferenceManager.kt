package com.example.culturle

import android.content.Context

class PreferenceManager() {
    fun getIntValue(targetKey:String, context : Context) : Int{
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        return preference.getInt(targetKey, 0)
    }

    fun getStrValue(targetKey:String, context : Context) : String{
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        val returnString = preference.getString(targetKey, "DEFAULT")
        return returnString.toString()
    }

    fun setIntPreference(targetKey:String, newValue:Int, context : Context) {
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putInt(targetKey, newValue)
        editor.apply()
    }

    fun setStrPreference(targetKey:String, newValue:String, context : Context) {
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(targetKey, newValue)
        editor.apply()
    }
}