package com.example.android_bootcamp_anuj


// Q3 WAP to create sealed Base class and 3 subclasses of Base class, write a function which will have
// base class object as an argument and it will return name of the subclass based argument type.


fun main(){
    println("\nQ3")
    val ob3 = A()
    val ob4 = B()
    val ob5 = C()
    ob3.getClass(ob3)
    ob3.getClass(ob4)
    ob3.getClass(ob5)
}

sealed class Q3 {
    val msg = "Hello xWorld!"


    fun getClass(base: Q3) {
        println("This is called from object of ${base.javaClass}")
    }
}

class A: Q3(){
}

class B: Q3(){
}

class C: Q3(){
}