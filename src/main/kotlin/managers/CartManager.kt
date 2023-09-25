package managers

import models.Cart
import models.Book
import interfaces.ICartManager

class CartManager(private val cart: Cart): ICartManager {
    override fun addBook(book: Book, quantity: Int) {
        val availableQuantity = book.getAvailableQuantity(book)
        if (availableQuantity >= quantity) {
            if (cart.items.containsKey(book)) {
                cart.items[book] = cart.items[book]!! + quantity
            } else {
                cart.items[book] = quantity
            }
        } else {
            println("Sorry, only $availableQuantity copies of ${book.title} are available.")
        }
    }

    override fun removeBook(book: Book, quantity: Int) {
        if (cart.items.containsKey(book)) {
            if (cart.items[book]!! > quantity) {
                cart.items[book] = cart.items[book]!! - quantity
            } else {
                cart.items.remove(book)
            }
        }
    }

    override fun viewCart(): Map<Book, Int> {
        return cart.items
    }

    override fun clearCart() {
        cart.items.clear()
    }
}
