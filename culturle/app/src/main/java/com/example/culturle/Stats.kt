package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

/**
 * Group Members: George Stewart ID: , Hayden Knox ID: , Hami Daly ID: , Marion Millard ID: , Micheal Young ID: ,
 * This class Object is the instance of a Game played by the user. Once the user clicks the play game button
 * from the main screen an instance of this class is created and the program is executed.
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
        aveGuessDisplay.setText("Average \n Guesses: \n" + aveGuess)

        var winPercentage = 0
        if(preferenceManager.getIntValue("gamesPlayed",this) != 0) {
            val doubleGamesWon = preferenceManager.getIntValue("gamesWon", this).toDouble()
            doubleGamesPlayed = preferenceManager.getIntValue("gamesPlayed", this).toDouble()
            winPercentage = ((doubleGamesWon / doubleGamesPlayed) * 100.0).roundToInt()
        }
        val winPercentageDisplay = findViewById<View>(R.id.winPercentageView) as TextView
        winPercentageDisplay.setText("Win %: \n " + winPercentage)

        val gamesPlayed = preferenceManager.getIntValue("gamesPlayed",this)
        val gamesPlayedDisplay = findViewById<View>(R.id.gamesPlayedView) as TextView
        gamesPlayedDisplay.setText("Games \n Played: \n" + gamesPlayed)

        val gamesWon = preferenceManager.getIntValue("gamesWon",this)
        val gamesWonDisplay = findViewById<View>(R.id.gamesWonView) as TextView
        gamesWonDisplay.setText("Games \n Won: \n" + gamesWon)

        val winStreak = preferenceManager.getIntValue("winStreak",this)
        val winStreakDisplay = findViewById<View>(R.id.winStreakView) as TextView
        winStreakDisplay.setText("Current \n Streak: \n" + winStreak)

        val bestStreak = preferenceManager.getIntValue("bestStreak",this)
        val bestStreakDisplay = findViewById<View>(R.id.bestStreakView) as TextView
        bestStreakDisplay.setText("Best \n Streak: \n" + bestStreak)

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