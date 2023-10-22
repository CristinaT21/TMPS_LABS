package managers

import composite.Product
import models.Cart
import interfaces.ICartManager

class CartManager(val cart: Cart): ICartManager {
    override fun addBook(product: Product, quantity: Int) {
        val availableQuantity = product.getAvailableQuantity()
        // verify if quantity from cart + quantity from user is less than available quantity, make sure not to have negative quantity

        var cartQuantity = cart.items[product]
        if (cartQuantity == null) {
            cartQuantity = 0
        }
        if (availableQuantity >= quantity && cartQuantity + quantity <= availableQuantity) {
            if (cart.items.containsKey(product)) {
                cart.items[product] = cart.items[product]!! + quantity
            } else {
                cart.items[product] = quantity
            }
        } else {
            println("Sorry, only $availableQuantity copies of ${product.getTitle()} are available.")
        }
    }

    override fun removeBook(product: Product, quantity: Int) {
        if (cart.items.containsKey(product)) {
            if (cart.items[product]!! > quantity) {
                cart.items[product] = cart.items[product]!! - quantity
            } else {
                cart.items.remove(product)
            }
        }
    }

    override fun viewCart(): Map<Product, Int> {
        return cart.items
    }

    override fun clearCart() {
        cart.items.clear()
    }
}
