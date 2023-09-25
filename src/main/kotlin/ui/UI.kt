package ui

import interfaces.IIdGenerator
import models.Book
import models.User
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

    fun customerChoice(): Int{
        println("1. View Catalog")
        println("2. View Book")
        println("3. Add to Cart")
        println("4. Remove from Cart")
        println("5. View Cart")
        println("6. Order")
        println("7. Logout")
        return readLine1()?.toIntOrNull() ?: 0
    }
    fun viewTitleAuthor():Pair<String, String>{
        println("Please enter the book title:")
        val title: String = readLine1() ?: ""
        println("Please enter the book author:")
        val author: String = readLine1() ?: ""
        return Pair(title, author)
    }
    fun choosecopyies(): Int{
        println("Please enter the number of copies:")
        return readLine1()?.toIntOrNull() ?: 0
    }
    fun getEmailFromUser(): String{
        println("Please enter your email:")
        return readLine1() ?: ""
    }
    fun getAddressFromUser(): String{
        println("Please enter your address:")
        return readLine1() ?: ""
    }
    fun validateCart(): Boolean{
        println("Please enter true if your cart info is valid:")
        return readLine1()?.toBoolean() ?: false
    }
    fun invalidCart(){
        println("Return and modify what is wrong.")
    }
    fun emptyCart(){
        println("Your cart is empty. Please add some books to your cart before placing an order.")
    }
    fun orderPlaced(user: User){
        println("Order has been placed successfully. Thank you for your order, ${user.username}!")
    }
    fun invalidChoice(){
        println("Invalid choice. Please try again.")
    }
}

//S - responsible for user interaction
//O - can add new methods, but not change existing ones to add new features
//I - The ui.UI class now implements an IIdGenerator interface through dependency injection
//D - It depends on the IIdGenerator abstraction, not on concrete classes. The
//   IIdGenerator is injected into the ui.UI class, making it easier to change the id
//   generation method in the future without modifying the ui.UI class.