package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

/**
 * This class Object is the instance of the home screen displayed when the app is run. From here the user has a number
 * of UI components displayed to access different game features. From here daily games, practice games, user stats and user informaiton
 * are displayed for easy access by the user.
 */
open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        //Set the screen to the activity_main.xml
        setContentView(R.layout.activity_main)

        //Boolean which determines whether the game instance is Daily mode or Practice mode
        var dailyMode = false

        //Check and update dates
        checkAndUpdateDateVariables()

        /*
        * This button is used to direct game users to the GamePlay page so that users may play the game using their
        * daily game allotment and their results will be updated to the Stats page.
        * Once clicked an instance of the Daily Class is created.
        */
        //Set button object to the dailyButton id
        val dailyButtonObj: Button = findViewById<View>(R.id.dailyButton) as Button
        //Create button listen event to switch over to Daily class activity with dailyMode set to true
        dailyButtonObj.setOnClickListener {
            if(preferenceManager.getIntValue("attemptedDaily", this) == 0) {
                preferenceManager.setIntPreference("attemptedDaily", 1, this)
                dailyMode = true
                val intent = Intent(this, Daily::class.java)
                intent.putExtra("dailyMode", dailyMode)
                startActivity(intent)
            } else {
                dailyMode = true
                val intent = Intent(this, AttemptedDailyScreen::class.java)
                startActivity(intent)
            }
        }
        /*
        * This button is used to direct game users to a daily game page where users may practice the game without using their
        * daily game allotment. Once clicked an instance of the Daily Class is created.
        */
        //Set button object to the practiceButton id
        val practiceButtonObj: Button = findViewById<View>(R.id.practiceButton) as Button
        //Create button listen event to switch over to Daily class activity with dailyMode set to false
        practiceButtonObj.setOnClickListener {
            dailyMode = false
            val intent = Intent(this, Daily::class.java)
            intent.putExtra("dailyMode", dailyMode)
            startActivity(intent)
        }
        /*
        * This button is used to direct game users to the user information page so that users may view the game information
        * Once clicked an instance of the Info Class is created.
        */
        //Set button object to the InfoButton id
        val infoButtonObj: ImageButton = findViewById<View>(R.id.infoButton) as ImageButton
        //Create button listen event to switch over to Practice class activity
        infoButtonObj.setOnClickListener {
            val intent = Intent(this, Info::class.java)
            intent.putExtra("dailyMode", dailyMode)
            startActivity(intent)
        }

        /*
        * This button is used to direct game users to their game stats page so that users may view their progress
        * Once clicked an instance of the Stats Class is created.
        */
        //This variable sets the button object to the statsButton id
        val statsButtonObj: ImageButton = findViewById<View>(R.id.statsButton) as ImageButton
        //Create button listen event to switch over to Practice class activity
        statsButtonObj.setOnClickListener {
            val intent = Intent(this, Stats::class.java)
            startActivity(intent)
        }
    }

    /**
    * Function which compares the activeDate and the currentDate and updates their values if needed
    */
    fun checkAndUpdateDateVariables() {
        val preferenceManager = PreferenceManager()
        val dateManager = DateManager()
        if(dateManager.isNewDay(this)) {
            preferenceManager.setIntPreference("attemptedDaily", 0, this)
        }
    }
}