package com.example.android_bootcamp_anuj

// Q4 WAP to create extension function.

fun main(){

    println("\nQ4")
    val ob6 = Q4()
    println("Extension function:")
    ob6.printDetails()

}


class Q4 {
    val num1: Int = 6

    // Extension function
    // Adding functionality to existing
    // Int class
    fun Int.Multiplication(num2: Int): Int {
        return this*num2
    }


    fun printDetails() {
        println("Multiplication is: " + 5.Multiplication(num1))
    }
}