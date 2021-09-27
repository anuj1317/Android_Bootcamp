package com.example.android_bootcamp_anuj

data class Employee(val name: String, val age: Int)
    val employeeList = listOf(
        Employee("Anuj", 23),
        Employee("Ankit", 35),
        Employee("Ram", 40),
        Employee("Shyam", 32),
        Employee("Steve", 24),
        Employee("Rogers", 44)
    )
val agefilter: (Employee) -> Boolean = { person: Employee -> person.age >30 }
fun main() {
    val result = employeeList.filter(agefilter)

//    println(result)
    result.forEach {
        println("Name: ${it.name}, Age: ${it.age}")
    }
}
