package com.example.culturle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Practice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Load practice.xml
        setContentView(R.layout.practice)
    }
}