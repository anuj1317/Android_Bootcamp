package com.example.android_bootcamp_anuj

// Q4 Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters,
// Digits And Other Special Characters In A String.

fun main() {
    println("Q4")
    val str = "anuj@#STRingTry"
    val totalStrLength = str.length

    var lowerCase = 0
    var upperCase = 0
    var specialAndDigitChar = 0

    for (i in 0 until totalStrLength) {
        if (str[i].isLowerCase())
            lowerCase++
        else if (str[i].isUpperCase())
            upperCase++
        else
            specialAndDigitChar++
    }
    println("Total Strength : $totalStrLength")
    println("\nNumber of lower case characters: $lowerCase, Percentage: ${(lowerCase.toFloat()/totalStrLength.toFloat())*100}%")
    println("Number of upper case characters: $upperCase, Percentage: ${(upperCase.toFloat()/totalStrLength.toFloat())*100}%")
    println("Number of special characters and digits: $specialAndDigitChar, Percentage: ${(specialAndDigitChar.toFloat()/totalStrLength.toFloat())*100}%\n")
}
