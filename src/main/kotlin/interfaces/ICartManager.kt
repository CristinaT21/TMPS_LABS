package interfaces

import models.Book
import models.Cart

interface ICartManager {
    fun addBook(book: Book, quantity: Int)
    fun removeBook(book: Book, quantity: Int)
    fun viewCart(): Map<Book, Int>
    fun clearCart()
}