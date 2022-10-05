package com.example.culturle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

/**
 * This class is called when a user attempts to play Daily mode more than once per day. If the user attempts to play daily mode once in a day,
 * this screen is displayed.
 */
class AttemptedDailyScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attempted_daily_screen)

        //Set button object to the practiceButton id
        val homeButtonObj: ImageButton = findViewById<View>(R.id.endHome) as ImageButton
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}