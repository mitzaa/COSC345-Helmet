package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val practiceButtonObj: Button = findViewById<View>(R.id.practiceButton) as Button
        practiceButtonObj.setOnClickListener {
            val intent = Intent(this, Practice::class.java)
            startActivity(intent)
        }
    }
}