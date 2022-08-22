package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * Group Members: George Stewart ID: , Hayden Knox ID: , Hami Daly ID: , Marion Millard ID: , Micheal Young ID: ,
 * This class Object is the instance of a Game completed by the user. Once the user has completed playing the game,
 * this end screen is displayed creating an instance of this class.
 */
class EndScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.culturle.R.layout.activity_end_screen)

        val todaysCountryDisplay = findViewById<View>(com.example.culturle.R.id.textView10) as TextView
        todaysCountryDisplay.setText(intent.getStringExtra("todaysCountry"))

        val todaysCountryFlag = findViewById<View>(com.example.culturle.R.id.countryFlagEnd) as ImageView
        val todaysArray = intent.getIntArrayExtra("todaysFlag")
        todaysCountryFlag.setImageResource(todaysArray!![1])

        //Set button object to the practiceButton id
        val homeButtonObj: Button = findViewById<View>(com.example.culturle.R.id.endHome) as Button
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}