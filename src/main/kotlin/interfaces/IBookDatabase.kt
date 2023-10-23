package interfaces

import composite.Product
import models.Book


interface IBookDatabase {
    fun addBook(book: Product)
    fun removeBook(book: Product)
    fun seeAllBooks()
    fun getBooks(): Map<Int, Product>
    fun getBookDetails(title: String, author: String): Product?
}