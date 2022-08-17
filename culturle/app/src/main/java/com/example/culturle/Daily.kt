package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.culturle.R
import android.widget.Toast



class Daily : AppCompatActivity() {

    private var b1: Button? = null
    private var iv: ImageView? = null
    private var flag = false
    private val images = intArrayOf(R.drawable.ic1, R.drawable.ic2, R.drawable.ic3)
    private var i = 0
    private var enteredText = "NONE"
    var guesses = 0;
    var todaysCountry = "NONE"
    private lateinit var binding: Daily


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)
        val autotextView = findViewById<AutoCompleteTextView>(R.id.autoTextView)
        // Get the array of countries
        val countries = resources.getStringArray(R.array.Countries)
        // Create adapter and add in AutoCompleteTextView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, countries
        )
        autotextView.setAdapter(adapter)

        todaysCountry = "Germany"

        val guessBtn = findViewById<Button>(R.id.guessButton)
        if (guessBtn != null) {
            guessBtn.setOnClickListener(View.OnClickListener {
                enteredText = autotextView.getText().toString()
                val enteredText = getString(R.string.submitted_country) + " " + autotextView.getText()
            })
            val autotextView = findViewById<AutoCompleteTextView>(R.id.autoTextView)
            val countries = resources.getStringArray(R.array.Countries)
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, countries
            )
            autotextView.setAdapter(adapter)
            flag = true
            b1 = findViewById<View>(R.id.guessButton) as Button
            iv = findViewById<View>(R.id.hintImage) as ImageView?
            b1!!.setOnClickListener {
                enteredText = autotextView.getText().toString()
                i++
                if (i == 3) i = 0
                iv!!.setImageResource(images[i])
                guesses++
                if(enteredText == todaysCountry) {
                    val intent = Intent(this, WinScreen::class.java)
                    startActivity(intent)
                }
                if (guesses == 6) {
                    val intent = Intent(this, EndScreen::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
