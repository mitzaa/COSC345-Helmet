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
            val gamesWon = preferenceManager.getIntValue("gamesWon",this)
            preferenceManager.setIntPreference("gamesWon",gamesWon + 1,this)

            val totalGuesses = preferenceManager.getIntValue("totalGuesses", this) + (intent.getIntExtra("numGuesses", 0))
            preferenceManager.setIntPreference("totalGuesses", totalGuesses,this)

            preferenceManager.setIntPreference("isWinStreak",1,this)
            val winStreak = preferenceManager.getIntValue("winStreak",this) + 1
            preferenceManager.setIntPreference("winStreak",winStreak,this)
            val bestStreak = preferenceManager.getIntValue("bestStreak",this)
            if(winStreak > bestStreak) {
                preferenceManager.setIntPreference("bestStreak",winStreak,this)
            }
        }

        val numGuessesDisplay = findViewById<View>(R.id.numGuessesView) as TextView
        numGuessesDisplay.setText("Guesses: " + intent.getIntExtra("numGuesses", 0))
        //val dateManager = DateManager()
        //num_guesses_display.setText("isNewDay " + dateManager.isNewDay(this) + "\n date: " + dateManager.getCurrentDate(this))

        val todaysCountryDisplay = findViewById<View>(R.id.textView10) as TextView
        todaysCountryDisplay.setText(intent.getStringExtra("todaysCountry"))

        val todaysCountryFlag = findViewById<View>(R.id.countryFlagEnd) as ImageView
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