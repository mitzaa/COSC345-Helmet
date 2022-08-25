package com.example.culturle

import android.content.Context
import java.util.Calendar

val preferenceManager = PreferenceManager()

class DateManager {
    fun getActiveDate(context : Context): Int {
        val activeDate = preferenceManager.getIntValue("activeDate", context)
        if(activeDate == 0) {
            val date = Calendar.YEAR + Calendar.MONTH + Calendar.DAY_OF_MONTH
            preferenceManager.setIntPreference("activeDate", date, context)
            preferenceManager.setIntPreference("currentDate", date, context)
        }
        return preferenceManager.getIntValue("activeDate", context)
    }

    fun getCurrentDate(context : Context): Int {
        val activeDate = preferenceManager.getIntValue("currentDate", context)
        if(activeDate == 0) {
            val date = Calendar.YEAR + Calendar.MONTH + Calendar.DAY_OF_MONTH
            preferenceManager.setIntPreference("currentDate", date, context)
        }
        return preferenceManager.getIntValue("currentDate", context)
    }

    fun updateDates(context : Context) {
        if(preferenceManager.getIntValue("currentDate", context) != preferenceManager.getIntValue("activeDate", context)) {
            val date = Calendar.YEAR + Calendar.MONTH + Calendar.DAY_OF_MONTH
            preferenceManager.setIntPreference("activeDate", date, context)
            preferenceManager.setIntPreference("currentDate", date, context)
        }
    }

    fun isNewDay(context : Context): Boolean {
        if(preferenceManager.getIntValue("currentDate", context) != preferenceManager.getIntValue("activeDate", context)) {
            return false
        }
        return true
    }

}