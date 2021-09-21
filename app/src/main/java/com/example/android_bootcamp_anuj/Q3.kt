package com.example.android_bootcamp_anuj

// Q3 Write a program to find the number of occurrences of a character in a string without using loop.


fun countOccurrences(s: String, ch: Char): Int {
    return s.filter { it == ch }.count()
}

fun main() {
    val s = "Anuj Singh Rawat"
    println(countOccurrences(s, 'a'))
}
