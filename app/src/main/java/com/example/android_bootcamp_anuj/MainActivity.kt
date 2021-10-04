package com.example.android_bootcamp_anuj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linear = findViewById<Button>(R.id.linearBtn)
        val relative = findViewById<Button>(R.id.relativeBtn)
        val constraint = findViewById<Button>(R.id.constraintBtn)


        // Linear Layout
        linear.setOnClickListener {
            startActivity(Intent(this, linear_layout::class.java))
        }

        // Relative layout
        relative.setOnClickListener {
            startActivity(Intent(this, Relative_layout::class.java))
        }

        // Constraint Layout
        constraint.setOnClickListener {
            startActivity(Intent(this, Constraint_layout::class.java))
        }



    }
}