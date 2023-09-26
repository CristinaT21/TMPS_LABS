package ui

import databases.BookDatabase
import interfaces.*
//import managers.BookManager
//import managers.InventoryManager
import managers.CartManager
import models.Cart
import models.Order
import models.User

class CustomerPage(private val ui: UI, cartManager: CartManager): ICustomerPage, IInventoryViewer,
    IBookInfoViewer, ICartAdder, ICartRemover, ICartViewer, IOrderPlacer, ILogout {
    override fun run(user: User) {
        println("Hello ${user.username}!")
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
            book.displayBook()
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
        Order(CartManager(cart), cart, user, ui, bookDatabase).place()
    }
    override fun logout(user: User) {
        println("Logout")
        println("Bye, ${user.username}!")
    }
}

// Interface Segregation Principle
// The CustomerPage class implements the IInventoryViewer, IBookInfoViewer, ICartAdder, ICartRemover, ICartViewer, IOrderPlacer, and ILogout interfaces.