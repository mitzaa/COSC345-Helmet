package com.example.culturle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Group Members: George Stewart ID: , Hayden Knox ID: , Hami Daly ID: , Marion Millard ID: , Micheal Young ID: ,
 * This class Object is the instance of a Practice Game played by the user. Once the user clicks the practice game button
 * from the main screen an instance of this class is created and the program is executed.
 */
class Practice : AppCompatActivity() {
    /*
    * The code in this class will be identical to the code
    * used to play the real game in the Daily class however the practice game mode will
    * not affect the game stats displayed in the Stats game page.
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Load activity_practice.xml
        setContentView(R.layout.activity_practice)
    }
}