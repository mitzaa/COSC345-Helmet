package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
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
        var textToDisplay = "Average \n Guesses: \n$aveGuess"
        aveGuessDisplay.text = textToDisplay

        var winPercentage = 0
        if(preferenceManager.getIntValue("gamesPlayed",this) != 0) {
            val doubleGamesWon = preferenceManager.getIntValue("gamesWon", this).toDouble()
            doubleGamesPlayed = preferenceManager.getIntValue("gamesPlayed", this).toDouble()
            winPercentage = ((doubleGamesWon / doubleGamesPlayed) * 100.0).roundToInt()
        }
        val winPercentageDisplay = findViewById<View>(R.id.winPercentageView) as TextView
        textToDisplay = "Win %: \n $winPercentage"
        winPercentageDisplay.text = textToDisplay

        val gamesPlayed = preferenceManager.getIntValue("gamesPlayed",this)
        val gamesPlayedDisplay = findViewById<View>(R.id.gamesPlayedView) as TextView
        textToDisplay = "Games \n Played: \n$gamesPlayed"
        gamesPlayedDisplay.text = textToDisplay

        val gamesWon = preferenceManager.getIntValue("gamesWon",this)
        val gamesWonDisplay = findViewById<View>(R.id.gamesWonView) as TextView
        textToDisplay = "Games \n Won: \n$gamesWon"
        gamesWonDisplay.text = textToDisplay

        val winStreak = preferenceManager.getIntValue("winStreak",this)
        val winStreakDisplay = findViewById<View>(R.id.winStreakView) as TextView
        textToDisplay = "Current \n Streak: \n$winStreak"
        winStreakDisplay.text = textToDisplay

        val bestStreak = preferenceManager.getIntValue("bestStreak",this)
        val bestStreakDisplay = findViewById<View>(R.id.bestStreakView) as TextView
        textToDisplay = "Best \n Streak: \n$bestStreak"
        bestStreakDisplay.text = textToDisplay

        //Set button object to the practiceButton id
        val homeButtonObj: ImageButton = findViewById<View>(R.id.homeStatsButton) as ImageButton
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Method used for unit testing allowing easy access to individual stat values
     */
    fun getStat( statName : String) : Int {
        val preferenceManager = PreferenceManager()
        return preferenceManager.getIntValue(statName, this)
    }
}
