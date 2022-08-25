package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
//import android.widget.ImageView
//import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * Group Members: George Stewart ID: , Hayden Knox ID: , Hami Daly ID: , Marion Millard ID: , Micheal Young ID: ,
 *
 */
class AttemptedDailyScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attempted_daily_screen)

        //Set button object to the homeButton id
        val homeButtonObj: Button = findViewById<View>(R.id.endHome) as Button
        //Create button listen event to return to MainActivity
        // Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}