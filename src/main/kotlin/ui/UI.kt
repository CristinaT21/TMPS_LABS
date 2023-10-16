package ui

import interfaces.User
import kotlin.io.readLine as readLine1

class UI {
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

    fun addBookInfo(): Array<Any> {
        println("Please enter the title of the book:")
        val title: String = readLine1() ?: ""
        println("Please enter the author of the book:")
        val author: String = readLine1() ?: ""
        println("Please enter the genre of the book:")
        val genre: String = readLine1() ?: ""
        println("Please enter the language of the book:")
        val language: String = readLine1() ?: ""
        println("Please enter the price of the book:")
        val price: Double = readLine1()?.toDoubleOrNull() ?: 0.0
        println("Please enter the number of pages of the book:")
        // if user enters a non-integer, round to nearest integer
        val input = readLine1()
        val numberOfPages: Int = if (input != null) {
            val floatNumber = input.toFloatOrNull()
            if (floatNumber !== null) {
                kotlin.math.round(floatNumber).toInt()
            } else {
                0
            }
        } else { 0
        }
        println("Please enter the quantity of the book:")
        val quantity: Int = (readLine1() ?.toIntOrNull() ?: 0)
        println("Please enter if book in stock:")
        val inStock: Boolean = readLine1()?.toBoolean() ?: true
        println("Please enter the age rating of the book:")
        val ageRate: Int = (readLine1() ?.toIntOrNull() ?: 0)
        println("Please enter the description of the book:")
        val description: String = readLine1() ?: ""
        return arrayOf(title, author, genre, language, price, numberOfPages, quantity, inStock, ageRate, description)
    }

    fun adminChoice(): Int {
        println("1. View Inventory")
        println("2. Add to Inventory")
        println("3. Logout")
        return readLine1()?.toIntOrNull() ?: 0
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
    fun askExitOrSwitchUser(): Boolean {
        println("Do you want to exit the application or switch user?")
        println("1. Exit")
        println("2. Switch user")
        val choice = readLine1()
        return choice == "1"
    }

    fun registerOrLogin(): Int {
        println("Please choose an option:")
        println("1. Register")
        println("2. Login")
        println("0. Logout")
        return readLine1()?.toIntOrNull() ?: 0
    }
}

//S - responsible for user interaction
//O - can add new methods, but not change existing ones to add new features
//I - The ui.UI class now implements an IIdGenerator interface through dependency injection
//D - It depends on the IIdGenerator abstraction, not on concrete classes. The
//   IIdGenerator is injected into the ui.UI class, making it easier to change the id
//   generation method in the future without modifying the ui.UI class.