package com.example.culturle

import android.content.Intent
//import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

/**
 * Group Members: George Stewart ID: , Hayden Knox ID: , Hami Daly ID: , Marion Millard ID: , Micheal Young ID: ,
 * This class Object is the instance of a game information screen accessed from the game home page.
 * Once the user clicks the view information UI button. Users are direct to this game to see relevant app information.
 */
class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        //val home_button_sound = MediaPlayer.create(this, R.raw.sound_byte_1)
        //Set button object to the practiceButton id
        val homeButtonObj: ImageButton = findViewById<View>(R.id.homeInfoButton) as ImageButton
        //Create button listen event to switch over to Practice class activity
        //Intent is the method of handling the switch
        homeButtonObj.setOnClickListener {
            //home_button_sound.start()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}