package com.example.android_bootcamp_anuj

// Q4 Create Kotlin classes having suitable attributes for Library management system.Use OOPs concepts
// in your design.Also try to use interfaces and abstract classes.

fun main(){

    println("\nQ4")
    val ob6 = Q4()
    val ob7 = Q4()
    ob6.addBook("Alchemist", 1, "Paulo Coelho")
    ob7.addBook("Database", 2, "Anuj")
    ob6.getBookDetails()
    ob7.getBookDetails()
}
abstract class Library {
    abstract fun addBook(bkName: String, bkID: Int, bkAutor: String)
}

interface BookDetails{
    fun getBookDetails()
}

class Q4: Library(), BookDetails{
    var bookName: String = ""
    var bookID: Int = 0
    var bookAuthor: String = ""

    override fun addBook(bkName: String, bkID: Int, bkAutor: String) {
        bookName = bkName
        bookID = bkID
        bookAuthor = bkAutor
    }

    override fun getBookDetails() {
        println("Book id: $bookID")
        println("Book name: $bookName")
        println("Book author: $bookAuthor\n")
    }
}