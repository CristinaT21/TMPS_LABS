package ui

import models.Book
import models.User
import utils.IIdGenerator
import kotlin.io.readLine as readLine1

class UI(private val idGenerator: IIdGenerator) {
    fun run() {
        println("Welcome to the Bookstore!")

    return
    }
    fun validateUser(): Pair<String, String> {
        println("Please enter your username:")
        val username: String = readLine1() ?: ""
        println("Please enter your password:")
        val password: String = readLine1() ?: ""
        return Pair(username, password)
    }

    fun addBook(): Book {
        val builder = Book.BookBuilder()
            .id(idGenerator.currentId())
        println("Please enter the title of the book:")
        builder.title = readLine1() ?: ""
        println("Please enter the author of the book:")
        builder.author = readLine1() ?: ""
        println("Please enter the genre of the book:")
        builder.genre = readLine1() ?: ""
        println("Please enter the language of the book:")
        builder.language = readLine1() ?: ""
        println("Please enter the price of the book:")
        builder.price = readLine1()?.toDoubleOrNull() ?: 0.0
        println("Please enter the number of pages of the book:")
        builder.numberOfPages = (readLine1() ?.toIntOrNull() ?: 0)
        println("Please enter if book in stock:")
        builder.inStock = readLine1()?.toBoolean() ?: true

        return builder.build()
    }
    fun adminChoice(): Int {
        println("1. View Inventory")
        println("2. Add to Inventory")
        println("3. Logout")
        return readLine1()?.toIntOrNull() ?: 0
    }

    fun bye(user: User?){
        if (user != null) {
            println("Bye, ${user.username}!")
        }
    }
}

//S - responsible for user interaction
//O - can add new methods, but not change existing ones to add new features
//I - The ui.UI class now implements an IIdGenerator interface through dependency injection
//D - It depends on the IIdGenerator abstraction, not on concrete classes. The
//   IIdGenerator is injected into the ui.UI class, making it easier to change the id
//   generation method in the future without modifying the ui.UI class.