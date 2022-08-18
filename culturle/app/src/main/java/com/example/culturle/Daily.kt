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
import java.nio.file.Files.size
import java.util.*
import kotlin.random.Random.Default.nextInt


class Daily : AppCompatActivity() {

    private var b1: Button? = null
    private var iv: ImageView? = null
    private var flag = false

    private val i001 = intArrayOf(R.drawable.i001_animal, R.drawable.i001_flag, R.drawable.i001_food, R.drawable.i001_lang,  R.drawable.i001_paint)
    private val i035 = intArrayOf(R.drawable.i035_animal, R.drawable.i035_flag, R.drawable.i035_food, R.drawable.i035_lang,  R.drawable.i035_paint)
    private val i040 = intArrayOf(R.drawable.i040_animal, R.drawable.i040_flag, R.drawable.i040_food, R.drawable.i040_lang,  R.drawable.i040_paint)
    private val i055 = intArrayOf(R.drawable.i055_animal, R.drawable.i055_flag, R.drawable.i055_food, R.drawable.i055_lang,  R.drawable.i055_paint)
    private val i061 = intArrayOf(R.drawable.i061_animal, R.drawable.i061_flag, R.drawable.i061_food, R.drawable.i061_lang,  R.drawable.i061_paint)
    private val i069 = intArrayOf(R.drawable.i069_animal, R.drawable.i069_flag, R.drawable.i069_food, R.drawable.i069_lang,  R.drawable.i069_paint)
    private val i111 = intArrayOf(R.drawable.i111_animal, R.drawable.i111_flag, R.drawable.i111_food, R.drawable.i111_lang,  R.drawable.i111_paint)
    private val i115 = intArrayOf(R.drawable.i115_animal, R.drawable.i115_flag, R.drawable.i115_food, R.drawable.i115_lang,  R.drawable.i115_paint)
    private val i124 = intArrayOf(R.drawable.i124_animal, R.drawable.i124_flag, R.drawable.i124_food, R.drawable.i124_lang,  R.drawable.i124_paint)
    private val i127 = intArrayOf(R.drawable.i127_animal, R.drawable.i127_flag, R.drawable.i127_food, R.drawable.i124_lang,  R.drawable.i124_paint)
    private val i170 = intArrayOf(R.drawable.i170_animal, R.drawable.i170_flag, R.drawable.i170_food, R.drawable.i170_lang,  R.drawable.i170_paint)
    private val i186 = intArrayOf(R.drawable.i186_animal, R.drawable.i186_flag, R.drawable.i186_food, R.drawable.i186_lang,  R.drawable.i186_paint)
    private val i187 = intArrayOf(R.drawable.i187_animal, R.drawable.i187_flag, R.drawable.i187_food, R.drawable.i187_lang,  R.drawable.i187_paint)
    var arr = arrayOf(i001, i035, i040, i055, i061, i069, i111, i115, i124, i127, i170, i186, i187)


    private var i = 0
    private var enteredText = "NONE"
    var guesses = 0;
    var todaysCountry = "NONE"
    private lateinit var binding: Daily


    override fun onCreate(savedInstanceState: Bundle?) {
        val myRandomValues = (0..arr.size).random()
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
            iv!!.setImageResource(arr[myRandomValues][0])
            b1!!.setOnClickListener {
                enteredText = autotextView.getText().toString()
                if(enteredText == todaysCountry) {
                    val intent = Intent(this, WinScreen::class.java)
                    startActivity(intent)
                }
                if (i == 4) {
                    val intent = Intent(this, EndScreen::class.java)
                    startActivity(intent)
                }
                if (i == 4) i = 0
                i++
                iv!!.setImageResource(arr[myRandomValues][i])
            }
        }
    }
}
