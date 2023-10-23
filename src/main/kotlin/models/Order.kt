package models

import ui.UI
import managers.CartManager
import databases.BookDatabase
import interfaces.IBookDatabase
import interfaces.ICartManager
import interfaces.User

class Order(val cartManager: ICartManager, val cart: Cart, val customer: User, val ui: UI, val bookDatabase: IBookDatabase) {
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
                    val product = item.key
                    product.updateQuantity(product.getAvailableQuantity()-item.value)
                }
                cartManager.clearCart()
            }
        }
    }

}