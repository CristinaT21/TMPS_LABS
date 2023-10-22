package interfaces

import composite.Product

interface ICartManager {
    fun addBook(product: Product, quantity: Int)
    fun removeBook(product: Product, quantity: Int)
    fun viewCart(): Map<Product, Int>
    fun clearCart()
}