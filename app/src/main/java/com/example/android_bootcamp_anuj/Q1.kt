package com.example.android_bootcamp_anuj

// Q2 WAP to create singleton class.

fun main() {
    println("Multiplicatiion is: ${Q2.multiply(2, 3)}")
    Q2.print()
    println("Singleton Class Variable =  ${Q2.name}")

}
object Q2 {
    //It can be accesed without creating an instance
    fun multiply(a: Int, b: Int) = a * b
    fun print(){
        println("Function called from Singleton class")
    }
    var name:String = "Anuj Singh"
}