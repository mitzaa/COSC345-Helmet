package com.example.culturle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Group Members: George Stewart ID: , Hayden Knox ID: , Hami Daly ID: , Marion Millard ID: , Micheal Young ID: ,
 * This class Object is the instance of a Winning screen created by the user successfully completing a game.
 * Once the user clicks the play game button from the main screen an instance of this class is created only when
 * the user guesses the answer country before the guess counter reaches its maximum.
 */
class WinScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_screen)

        val preferenceManager = PreferenceManager()

        val dailyMode = intent.getBooleanExtra("dailyMode", false)
        if(dailyMode) {
            var gamesWon = preferenceManager.getIntValue("gamesWon",this)
            preferenceManager.setIntPreference("gamesWon",gamesWon + 1,this)

            var totalGuesses = preferenceManager.getIntValue("totalGuesses", this) + (intent.getIntExtra("numGuesses", 0))
            preferenceManager.setIntPreference("totalGuesses", totalGuesses,this)

            preferenceManager.setIntPreference("isWinStreak",1,this)
            var winStreak = preferenceManager.getIntValue("winStreak",this) + 1
            preferenceManager.setIntPreference("winStreak",winStreak,this)
            var bestStreak = preferenceManager.getIntValue("bestStreak",this)
            if(winStreak > bestStreak) {
                preferenceManager.setIntPreference("bestStreak",winStreak,this)
            }
        }

        val num_guesses_display = findViewById<View>(com.example.culturle.R.id.numGuessesView) as TextView
        num_guesses_display.setText("Guesses: " + intent.getIntExtra("numGuesses", 0))

        val todays_country_display = findViewById<View>(com.example.culturle.R.id.textView10) as TextView
        todays_country_display.setText(intent.getStringExtra("todaysCountry"))

        val todaysCountryFlag = findViewById<View>(com.example.culturle.R.id.countryFlagEnd) as ImageView
        val todaysArray = intent.getIntArrayExtra("todaysFlag")
        todaysCountryFlag.setImageResource(todaysArray!![1])

        //Set button object to the practiceButton id
        val homeButtonObj: Button = findViewById<View>(R.id.winHome) as Button
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}