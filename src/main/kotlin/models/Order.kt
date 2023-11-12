package models

import AppController
import interfaces.*
import ui.UI

class Order(val cartManager: ICartManager, val cart: Cart, val customer: User, val ui: UI, val bookDatabase: IBookDatabase, private val handlerChain: IHandlerChain, val discountStrategy: DiscountStrategy) {

    fun place() {
        if (cart.items.isEmpty()) {
            ui.emptyCart()
            return
        }
        else {
            var price = 0.0
            for (item in cart.items) {
                println(item)
                price += item.key.price
            }
            println("Initial price to pay $price.")
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
                // apply discount
                price = discountStrategy.applyDiscount(price)
                println("Amount to be paid $price.")
                // process payment
                if (!handlerChain.processPayment(price, AppController.payments))
                {
                    ui.paymentFailed()
                    return
                }

                cartManager.clearCart()
            }
        }
    }
}