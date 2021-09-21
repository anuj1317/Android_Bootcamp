package com.example.android_bootcamp_anuj

// Q6 Check letter in string which do not have pair.

fun main() {
    println("Q6")
    val str = "AABDDC"
    var i = 0
    println("Non pair elements are: ")
    while (i < str.length-1) {
        if (str[i] != str[i+1]) {
            print(str[i] + " ")
            i++
        }
        else
            i += 2
    }
    if (str[str.length-1] != str[str.length-2])
        print(str[str.length-1])
}