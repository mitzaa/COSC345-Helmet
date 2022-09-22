package com.example.culturle

import android.content.Context
import java.util.Calendar

val preferenceManager = PreferenceManager()

/**
 * A class which uses PreferenceManager and Calendar to track and modify the currentDate and
 * the activeDate being used by the application.
 */
class DateManager {
    private fun getActiveDate(context : Context): String {
        val activeDate = preferenceManager.getStrValue("activeDate", context)
        if(activeDate == "DEFAULT") {
            val date = getCurrentDate()
            preferenceManager.setStrPreference("activeDate", date, context)
        }
        return preferenceManager.getStrValue("activeDate", context)
    }

    private fun getCurrentDate(): String {
        val currentDate = Calendar.getInstance()
        return currentDate.time.toString().substring(0, 10)
    }

    fun isNewDay(context : Context): Boolean {
        if(getCurrentDate() == getActiveDate(context)) {
            return false
        }
        updateDates(context)
        return true
    }

    private fun updateDates(context : Context) {
        if(getCurrentDate() != getActiveDate(context)) {
            val date = getCurrentDate()
            preferenceManager.setStrPreference("activeDate", date, context)
        }
    }

}