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
    public var guesses = 0;
    private lateinit var binding: Daily
    //CI test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)
        val autotextView = findViewById<AutoCompleteTextView>(R.id.autoTextView)
        // Get the array of languages
        val languages = resources.getStringArray(R.array.Languages)
        // Create adapter and add in AutoCompleteTextView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, languages
        )
        autotextView.setAdapter(adapter)

        val button = findViewById<Button>(R.id.btn)
        if (button != null) {
            button?.setOnClickListener(View.OnClickListener {
                val enteredText = getString(R.string.submitted_lang) + " " + autotextView.getText()
            })

            val autotextView = findViewById<AutoCompleteTextView>(R.id.autoTextView)
            val languages = resources.getStringArray(R.array.Languages)
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, languages
            )
            autotextView.setAdapter(adapter)
            flag = true
            b1 = findViewById<View>(R.id.guessButton) as Button
            iv = findViewById<View>(R.id.hintImage) as ImageView?
            b1!!.setOnClickListener {
                i++
                if (i == 3) i = 0
                iv!!.setImageResource(images[i])
                guesses++
                if (guesses == 6) {
                    val intent = Intent(this, EndScreen::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
