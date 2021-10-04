package com.example.android_bootcamp_anuj

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar

class Relative_layout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        // Custom Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Restaurants"
        toolbar.setTitleTextColor(Color.WHITE)
        setActionBar(toolbar)

    }
}