package com.example.culturle

import android.content.Context
import java.util.Calendar

val preferenceManager = PreferenceManager()

/**
 * A class which uses PreferenceManager and Calendar to track and modify the currentDate and
 * the activeDate being used by the application.
 */
class DateManager {
    fun getActiveDate(context : Context): String {
        val activeDate = preferenceManager.getStrValue("activeDate", context)
        if(activeDate == "DEFAULT") {
            var currentDate = Calendar.getInstance()
            var date = currentDate.getTime().toString().substring(0, 10)
            preferenceManager.setStrPreference("activeDate", date, context)
            preferenceManager.setStrPreference("currentDate", date, context)
        }
        return preferenceManager.getStrValue("activeDate", context)
    }

    fun getCurrentDate(context : Context): String {
        val currentDate = preferenceManager.getStrValue("currentDate", context)
        if(currentDate == "DEFAULT") {
            var currentDate = Calendar.getInstance()
            val date = currentDate.getTime().toString().substring(0, 10)
            preferenceManager.setStrPreference("currentDate", date, context)
            preferenceManager.setStrPreference("activeDate", date, context)
        }
        return preferenceManager.getStrValue("currentDate", context)
    }

    fun updateDates(context : Context) {
        if(preferenceManager.getStrValue("currentDate", context) != preferenceManager.getStrValue("activeDate", context)) {
            var currentDate = Calendar.getInstance()
            var date = currentDate.getTime().toString().substring(0, 10)
            preferenceManager.setStrPreference("activeDate", date, context)
            preferenceManager.setStrPreference("currentDate", date, context)
        }
    }

    fun isNewDay(context : Context): Boolean {
        if(preferenceManager.getStrValue("currentDate", context) == preferenceManager.getStrValue("activeDate", context)) {
            return false
        }
        return true
    }

}