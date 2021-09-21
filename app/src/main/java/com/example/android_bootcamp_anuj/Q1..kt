package com.example.android_bootcamp_anuj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Q1 Write a program to replace a substring inside a string with another string.
fun main() {

    println("Q1")
    val str1 = "Hello Boys"

    println("Original string: $str1")
    println("Replaced string: ${str1.replace("Boys", "World", true)}\n")

}