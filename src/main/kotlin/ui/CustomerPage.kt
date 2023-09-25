package ui

import databases.BookDatabase
import interfaces.*
//import managers.BookManager
//import managers.InventoryManager
import managers.CartManager
import models.Cart
import models.Order
import models.User

class CustomerPage(private val ui: UI): ICustomerPage, IInventoryViewer,
    IBookInfoViewer, ICartAdder, ICartRemover, ICartViewer, IOrderPlacer, ILogout {
    override fun run(user: User) {
        println("Hello ${user.username}!")
    }
    fun chooseActions(user: User, bookDatabase: BookDatabase, cart: Cart){
        // loop through choices
        val cartManager = CartManager(cart)
        while (true) {
            val choice = ui.customerChoice()
            when (choice) {
                1 -> { viewInventory(bookDatabase) }
                2 -> { viewBookInfo(bookDatabase) }
                3 -> { addToCart(cartManager, bookDatabase) }
                4 -> { removeFromCart(cartManager, bookDatabase) }
                5 -> { viewCart(cartManager) }
                6 -> { placeOrder(cart, user, bookDatabase) }
                7 -> { logout(user)
                         break  }
                else -> { ui.invalidChoice() }
            }
        }
    }
    override fun viewInventory(bookDatabase: BookDatabase) {
        println("View Catalog")
        bookDatabase.seeAllBooks()
    }
    override fun viewBookInfo(bookDatabase: BookDatabase) {
        println("View Book Details")
        // get book details
        val titleAuthor = ui.viewTitleAuthor()
        val book = bookDatabase.getBookDetails(titleAuthor.first, titleAuthor.second)
        if (book != null) {
            println(book.displayBook())
        } else {
            println("Book not found.")
        }
    }
    override fun addToCart(cartManager: CartManager, bookDatabase: BookDatabase) {
        println("Add to Cart")
        // add book to cart
        val titleAuthor = ui.viewTitleAuthor()
        cartManager.addBook(bookDatabase.getBookDetails(titleAuthor.first, titleAuthor.second), ui.choosecopyies())
    }

    override fun removeFromCart(cartManager: CartManager, bookDatabase: BookDatabase) {
        println("Remove from Cart")
        // remove book from cart
        val titleAuthor = ui.viewTitleAuthor()
        cartManager.removeBook(bookDatabase.getBookDetails(titleAuthor.first, titleAuthor.second), ui.choosecopyies())
    }
    override fun viewCart(cartManager: CartManager) {
        println("View Cart")
        // view cart
        println(cartManager.viewCart())
    }
    override fun placeOrder(cart: Cart, user: User, bookDatabase: BookDatabase) {
        println("Order")
        // place order
        Order(CartManager(Cart()), cart, user, ui, bookDatabase).place()
    }
    override fun logout(user: User) {
        println("Logout")
        ui.bye(user)
    }
}

// Interface Segregation Principle
// The CustomerPage class implements the IInventoryViewer, IBookInfoViewer, ICartAdder, ICartRemover, ICartViewer, IOrderPlacer, and ILogout interfaces.