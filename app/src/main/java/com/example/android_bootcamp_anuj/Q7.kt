package com.example.android_bootcamp_anuj

// Write a program to create mutable map. print all the value and key of map.


fun main() {
    val mMap = mutableMapOf<Int, String>(Pair(1, "Hello"), Pair(2, "Anuj"), Pair(3, "Singh"))
    for (item in mMap) {
        println("Key: ${item.key}, Value: ${item.value}")
    }
}