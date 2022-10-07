package com.example.culturle

import android.content.Intent
import android.content.ClipData
import android.content.ClipboardManager
//import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


/**
 * This class is called when a user loses a game. Once the user has lost a game,
 * this end screen is displayed.
 */
class EndScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //val beginSound = MediaPlayer.create(this, R.raw.sound_byte_1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)

        val preferenceManager = PreferenceManager()

        val dailyMode = intent.getBooleanExtra("dailyMode", false)
        if(dailyMode) {
            val totalGuesses = (preferenceManager.getIntValue("totalGuesses", this) + 5)
            preferenceManager.setIntPreference("totalGuesses", totalGuesses,this)

            preferenceManager.setIntPreference("isWinStreak",0,this)
            preferenceManager.setIntPreference("winStreak", 0,this)
        }


        // Grab image and text views by id and then set them to today's countries
        val todaysCountryDisplay = findViewById<View>(R.id.textView10) as TextView
        todaysCountryDisplay.text = intent.getStringExtra("todaysCountry")

        val todaysCountryFlag = findViewById<View>(R.id.countryFlagEnd) as ImageView
        val todaysArray = intent.getIntArrayExtra("todaysFlag")
        todaysCountryFlag.setImageResource(todaysArray!![1])

        //Set button object to the practiceButton id
        val homeButtonObj: ImageButton = findViewById<View>(R.id.endHome) as ImageButton
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            //beginSound.start()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val shareButton: ImageButton = findViewById<View>(R.id.shareResults) as ImageButton
        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        shareButton!!.setOnClickListener {
            val clipData = ClipData.newPlainText("label", "My culturle score: ❌ ❌ ❌ ❌ ❌")
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this@EndScreen, "Results Copied", Toast.LENGTH_SHORT).show()
        }
    }
}