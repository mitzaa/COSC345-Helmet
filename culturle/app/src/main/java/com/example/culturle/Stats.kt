package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

/**
 * This class Object retrieves, calculates, displays the user's stats from Daily mode. It shows Average Guesses,
 * Win Percentage, Games Played, Games Won, Win Streak, and Best Streak.
 */
class Stats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        val preferenceManager = PreferenceManager()

        var aveGuess = 0.0
        var doubleGamesPlayed = preferenceManager.getIntValue("gamesPlayed",this).toDouble()
        val doubleTotalGuesses = preferenceManager.getIntValue("totalGuesses", this).toDouble()
        if(preferenceManager.getIntValue("gamesPlayed",this) != 0) {
            aveGuess = ((doubleTotalGuesses / doubleGamesPlayed) * 100.0).roundToInt() / 100.0
        }
        val aveGuessDisplay = findViewById<View>(R.id.aveGuessesView) as TextView
        aveGuessDisplay.text = "Average \n Guesses: \n$aveGuess"

        var winPercentage = 0
        if(preferenceManager.getIntValue("gamesPlayed",this) != 0) {
            val doubleGamesWon = preferenceManager.getIntValue("gamesWon", this).toDouble()
            doubleGamesPlayed = preferenceManager.getIntValue("gamesPlayed", this).toDouble()
            winPercentage = ((doubleGamesWon / doubleGamesPlayed) * 100.0).roundToInt()
        }
        val winPercentageDisplay = findViewById<View>(R.id.winPercentageView) as TextView
        winPercentageDisplay.text ="Win %: \n $winPercentage"

        val gamesPlayed = preferenceManager.getIntValue("gamesPlayed",this)
        val gamesPlayedDisplay = findViewById<View>(R.id.gamesPlayedView) as TextView
        gamesPlayedDisplay.text = "Games \n Played: \n$gamesPlayed"

        val gamesWon = preferenceManager.getIntValue("gamesWon",this)
        val gamesWonDisplay = findViewById<View>(R.id.gamesWonView) as TextView
        gamesWonDisplay.text = "Games \n Won: \n$gamesWon"

        val winStreak = preferenceManager.getIntValue("winStreak",this)
        val winStreakDisplay = findViewById<View>(R.id.winStreakView) as TextView
        winStreakDisplay.text = "Current \n Streak: \n$winStreak"

        val bestStreak = preferenceManager.getIntValue("bestStreak",this)
        val bestStreakDisplay = findViewById<View>(R.id.bestStreakView) as TextView
        bestStreakDisplay.text = "Best \n Streak: \n$bestStreak"

        //Set button object to the practiceButton id
        val homeButtonObj: Button = findViewById<View>(R.id.homeStatsButton) as Button
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
