package com.example.android_bootcamp_anuj

// Write a single program for following operation using overloading
// A) Adding 2 integer number
// B) Adding 2 double
// D) multiplying 2 int
// E) concate 2 string
// F) Concate 3 String

fun main(){
    println("\nQ2")
    val ob2 = Q2()
    ob2.addInteger(2, 2)
    ob2.addDouble(5.5, 4.6)
    ob2.multiplyInt(5, 5)
    ob2.concatString("Anuj ", "Singh")
    ob2.concatThreeStrings("Introduction ", "to ", "Kotlin ")
}

// Interface
interface Operations {

    fun addInteger(x: Int, y: Int)

    fun addDouble(x: Double, y: Double)

    fun multiplyInt(x: Int, y: Int)

    fun concatString(str1: String, str2: String)

    fun concatThreeStrings(str1: String, str2: String, str3: String)
}

class Q2: Operations {
    override fun addInteger(x: Int, y: Int) {
        println("Sum of Int = ${x+y}")
    }

    override fun addDouble(x: Double, y: Double) {
        println("Sum of Double = ${x+y}")
    }

    override fun multiplyInt(x: Int, y: Int) {
        println("Mutiplication of Int = ${x*y}")
    }

    override fun concatString(str1: String, str2: String) {
        println("Two concatenated strings = ${str1.plus(str2)}")
    }

    override fun concatThreeStrings(str1: String, str2: String, str3: String) {
        println("Three concatenated strings = ${str1.plus(str2).plus(str3)}")
    }


}