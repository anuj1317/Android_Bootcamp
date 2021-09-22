package com.example.android_bootcamp_anuj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Q1 Write a program to print your Firstname, LastName & age using init block,companion object.

fun main() {
    println("Q1")
    val ob1 = Q1()
    // calling method
    ob1.printDetails()

    // printing details from Companion object
    println("\nValue initialised from companion object")
    println("First name: ${Q1.fname}")
    println("Last name: ${Q1.lname}")
    println("Age: ${Q1.age}")

}

class Q1 {

    // Companion object make it public static
    // So we can access it just as using ClassName.propertyName
    companion object {
        const val fname = "Ankit"
        const val lname = "Singh"
        const val age = 27
    }

    var fname: String? = null
    var lname: String? = null
    var age: String? = null

    // init will initialise values
    init {
        fname = "Anuj"
        lname = "Singh"
        age = "23"

    }

    fun printDetails() {
        println("Value initialised from init block")
        println("First name: $fname")
        println("Last name: $lname")
        println("Age: $age")
    }

}