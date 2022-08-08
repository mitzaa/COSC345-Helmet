package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        //Set the screen to the activity_main.xml
        setContentView(R.layout.activity_main)

        //Set button object to the dailyButton id
        val dailyButtonObj: Button = findViewById<View>(R.id.dailyButton) as Button
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        dailyButtonObj.setOnClickListener {
            val intent = Intent(this, Daily::class.java)
            startActivity(intent)
        }

        //Set button object to the practiceButton id
        val practiceButtonObj: Button = findViewById<View>(R.id.practiceButton) as Button
        //Create button listen event to switch over to Practice class activity
        // Intent is the method of handling the switch
        practiceButtonObj.setOnClickListener {
            val intent = Intent(this, Practice::class.java)
            startActivity(intent)
        }
        //Test
    }
}