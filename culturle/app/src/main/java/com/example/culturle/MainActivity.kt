package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

/**
 * Group Members: George Stewart ID: , Hayden Knox ID: 2485857 , Hami Daly ID: , Marion Millard ID: , Micheal Young ID: ,
 * This class Object is the instance of the home screen displayed when the app is run. From here the game user has a number
 * of UI components displayed to access different game features. From here Gameplay, Game practice, user states and user informaiton
 * is displayed for easy user access.
 */
open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        //Set the screen to the activity_main.xml
        setContentView(R.layout.activity_main)

        //Doc Test

        //Boolean which determines whether this game instance is Daily mode or Practice mode
        var dailyMode = false

        val preferenceManager = PreferenceManager()
        val dateManager = DateManager()
        dateManager.getCurrentDate(this)
        if(dateManager.isNewDay(this)) {
            preferenceManager.setIntPreference("attemptedDaily", 0, this)
            dateManager.updateDates(this)
        }


        /*
        * This button is used to direct game users to the GamePlay page so that users may play the game using their
        * daily game allotment and their results will be updated to the Stats page.
        * Once clicked an instance of the Daily Class is created.
        */
        //Set button object to the dailyButton id
        val dailyButtonObj: Button = findViewById<View>(R.id.dailyButton) as Button
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
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
        * This button is used to direct game users to the practice game page so that users may practice the game without using their
        * daily game allotment. Once clicked an instance of the Practice Class is created.
        */
        //Set button object to the practiceButton id
        val practiceButtonObj: Button = findViewById<View>(R.id.practiceButton) as Button
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
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
        // Intent is the method of handling the switch
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
        // Intent is the method of handling the switch
        statsButtonObj.setOnClickListener {
            val intent = Intent(this, Stats::class.java)
            startActivity(intent)
        }
    }
}