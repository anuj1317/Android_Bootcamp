package com.example.android_bootcamp_anuj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Q1 WAP to produce NoClassDefFoundError and ClassNotFoundException exception.

fun main() {

    println("Q1")
    // For ClassNotFoundException
    try {
        Class.forName("Abc1")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

class Q1 {
    val msg = "This is class Q1"

    fun printMsg() {
        println(msg)
    }
}