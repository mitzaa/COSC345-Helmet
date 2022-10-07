package com.example.culturle

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This class Object is the instance of a Winning screen created by the user successfully completing a game.
 * Once the user clicks the play game button from the main screen an instance of this class is created only when
 * the user guesses the answer country before the guess counter reaches its maximum.
 */
class WinScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_screen)
        //val beginSound = MediaPlayer.create(this, R.raw.sound_byte_1)
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
        val numGuessesValue = intent.getIntExtra("numGuesses", 0)
        val numGuessesString = "Guesses $numGuessesValue"
        numGuessesDisplay.text = numGuessesString

        val todaysCountryDisplay = findViewById<View>(R.id.textView10) as TextView
        todaysCountryDisplay.text = intent.getStringExtra("todaysCountry")

        val todaysCountryFlag = findViewById<View>(R.id.countryFlagEnd) as ImageView
        val todaysArray = intent.getIntArrayExtra("todaysFlag")
        todaysCountryFlag.setImageResource(todaysArray!![1])

        //Set button object to the practiceButton id
        val homeButtonObj: ImageButton = findViewById<View>(R.id.winHome) as ImageButton
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            //beginSound.start()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var resultsString = "";
        if (numGuessesValue == 5) {
            resultsString = "My culturle score: ❌ ❌ ❌ ❌";
        }else if (numGuessesValue == 4) {
            resultsString = "My culturle score: ❌ ❌ ❌ ✅"
        }else if(numGuessesValue == 3) {
            resultsString = "My culturle score: ❌ ❌ ✅"
        }else if(numGuessesValue == 2) {
            resultsString = "My culturle score: ❌ ✅"
        }else {
            resultsString = "My culturle score: ✅"
        }


        val shareButton: ImageButton = findViewById<View>(R.id.shareResults) as ImageButton
        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        shareButton!!.setOnClickListener {
            val clipData = ClipData.newPlainText("label", resultsString)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this@WinScreen, "Score copied", Toast.LENGTH_SHORT).show()

        }
    }
}