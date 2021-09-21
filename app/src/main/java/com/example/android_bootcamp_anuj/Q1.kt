package com.example.android_bootcamp_anuj

fun replaceString() {
    val str1 = "Hello Boys"

    println("Original string: $str1")
    println("Replaced string: ${str1.replace("Boys", "World", true)}\n")
}

