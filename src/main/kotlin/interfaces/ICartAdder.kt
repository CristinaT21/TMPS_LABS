package interfaces

import databases.BookDatabase
import managers.CartManager

interface ICartAdder {
    fun addToCart(cartManager: CartManager, bookDatabase: BookDatabase){}
}