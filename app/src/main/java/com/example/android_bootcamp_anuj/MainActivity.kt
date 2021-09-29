package com.example.android_bootcamp_anuj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginbutton = findViewById<Button>(R.id.login)
        loginbutton.setOnClickListener {
            val intent = Intent(this, homeactivity::class.java)
           startActivity(intent)
        }
    }
}