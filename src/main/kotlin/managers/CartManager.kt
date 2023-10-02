package managers

import models.Cart
import models.Book
import interfaces.ICartManager

class CartManager(val cart: Cart): ICartManager {
    override fun addBook(book: Book, quantity: Int) {
        val availableQuantity = book.getAvailableQuantity(book)
        // verify if quantity from cart + quantity from user is less than available quantity, make sure not to have negative quantity

        var cartQuantity = cart.items[book]
        if (cartQuantity == null) {
            cartQuantity = 0
        }
        if (availableQuantity >= quantity && cartQuantity + quantity <= availableQuantity) {
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
