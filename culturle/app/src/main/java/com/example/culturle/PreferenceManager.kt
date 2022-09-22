package com.example.culturle

import android.content.Context

/**
 * A class which manages local storage of variables on the device using SharedPreferences.
 */
class PreferenceManager {
    /**
     * A function used to get the value of integer variables held by the
     * preference manager.
     */
    fun getIntValue(targetKey:String, context : Context) : Int{
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        return preference.getInt(targetKey, 0)
    }

    /**
     * A function used to get the value of String variables held by the
     * preference manager.
     */
    fun getStrValue(targetKey:String, context : Context) : String{
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        return preference.getString(targetKey, "DEFAULT").toString()
    }

    /**
     * A function used to set the value of integer variables held by the
     * preference manager.
     */
    fun setIntPreference(targetKey:String, newValue:Int, context : Context) {
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putInt(targetKey, newValue)
        editor.apply()
    }

    /**
     * A function used to set the value of String variables held by the
     * preference manager.
     */
    fun setStrPreference(targetKey:String, newValue:String, context : Context) {
        val preference = context.getSharedPreferences(targetKey, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(targetKey, newValue)
        editor.apply()
    }
}