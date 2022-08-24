package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        val aveGuess = preferenceManager.getValue("totalGuesses",this)/preferenceManager.getValue("gamesPlayed",this)
        val aveGuessDisplay = findViewById<View>(com.example.culturle.R.id.aveGuessesView) as TextView
        aveGuessDisplay.setText("Average \n Guesses: \n" + aveGuess)

        val gamesPlayed = preferenceManager.getValue("gamesPlayed",this) + 1
        val gamesPlayedDisplay = findViewById<View>(com.example.culturle.R.id.gamesPlayedView) as TextView
        gamesPlayedDisplay.setText("Games \n Played: \n" + gamesPlayed)

        val gamesWon = preferenceManager.getValue("gamesWon",this)
        val gamesWonDisplay = findViewById<View>(com.example.culturle.R.id.gamesWonView) as TextView
        gamesWonDisplay.setText("Games \n Won: \n" + gamesWon)


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