package com.example.culturle

import android.content.Context
import java.util.Calendar

val preferenceManager = PreferenceManager()

class DateManager {
    fun getActiveDate(context : Context): String {
        val activeDate = preferenceManager.getStrValue("activeDate", context)
        if(activeDate == "DEFAULT") {
            var date = (Calendar.YEAR).toString() + (Calendar.MONTH).toString() + (Calendar.DAY_OF_MONTH).toString()
            preferenceManager.setStrPreference("activeDate", date, context)
            preferenceManager.setStrPreference("currentDate", date, context)
        }
        return preferenceManager.getStrValue("activeDate", context)
    }

    fun getCurrentDate(context : Context): String {
        val activeDate = preferenceManager.getStrValue("currentDate", context)
        if(activeDate == "DEFAULT") {
            var date = (Calendar.YEAR).toString() + (Calendar.MONTH).toString() + (Calendar.DAY_OF_MONTH).toString()
            preferenceManager.setStrPreference("currentDate", date, context)
        }
        return preferenceManager.getStrValue("currentDate", context)
    }

    fun updateDates(context : Context) {
        if(preferenceManager.getStrValue("currentDate", context) != preferenceManager.getStrValue("activeDate", context)) {
            var date = (Calendar.YEAR).toString() + (Calendar.MONTH).toString() + (Calendar.DAY_OF_MONTH).toString()
            preferenceManager.setStrPreference("activeDate", date, context)
            preferenceManager.setStrPreference("currentDate", date, context)
        }
    }

    fun isNewDay(context : Context): Boolean {
        if(preferenceManager.getStrValue("currentDate", context) != preferenceManager.getStrValue("activeDate", context)) {
            return false
        }
        return true
    }

    fun getDay(): String{
        return ((Calendar.DAY_OF_MONTH).toString())
    }

    fun getMonth(): String{
        return ((Calendar.MONTH).toString())
    }

    fun getYear(): String{
        return ((Calendar.YEAR).toString())
    }

}