package com.example.android_bootcamp_anuj

// Write a program to create mutable list of Integer. replace the second item in the list with
// new value. Print the list value.


fun main(){
    println("Q6")
    val list1 = mutableListOf(1,6,3,4)
    println("Original list = $list1")
    list1[1] = 2
    println("Changed list = $list1")
}