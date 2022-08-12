package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.culturle.R

class Daily : AppCompatActivity() {

    private var b1: Button? = null
    private var iv: ImageView? = null
    private var flag = false
    private val images = intArrayOf(R.drawable.ic1, R.drawable.ic2, R.drawable.ic3)
    private var i = 0
    public var guesses = 0;
    private lateinit var binding: Daily
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)
        flag = true
        b1 = findViewById<View>(R.id.guessButton) as Button
        iv = findViewById<View>(R.id.hintImage) as ImageView?
        b1!!.setOnClickListener {
            i++
            if (i == 3) i = 0
            iv!!.setImageResource(images[i])
            guesses++
            if(guesses==6){
                val intent = Intent(this, EndScreen::class.java)
                startActivity(intent)
            }
        }
    }
}
