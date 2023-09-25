package interfaces

import databases.BookDatabase
import managers.CartManager

interface ICartRemover {
    fun removeFromCart(cartManager: CartManager, bookDatabase: BookDatabase){}
}