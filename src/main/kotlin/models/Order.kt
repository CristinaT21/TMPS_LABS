package models

import ui.UI
import managers.CartManager
import databases.BookDatabase
import interfaces.ICartManager

class Order(val cartManager: ICartManager, val cart: Cart, val customer: User, val ui: UI, val bookDatabase: BookDatabase) {
    fun place() {
        if (cart.items.isEmpty()) {
            ui.emptyCart()
            return
        }
        else {
            for (item in cart.items) {
                println(item)
            }
            // Ask for email and address
            val email = ui.getEmailFromUser()
            val address = ui.getAddressFromUser()
            // Validate cart
            val valid = ui.validateCart()
            if (!valid) {
                ui.invalidCart()
                return
            } else {
                ui.orderPlaced(customer)
                // from database delete ordered books
                for (item in cart.items) {
                    val book = item.key
                    book.updateQuantity(item.key, book.quantity-item.value)
                }
                cartManager.clearCart()
            }
        }
    }

}