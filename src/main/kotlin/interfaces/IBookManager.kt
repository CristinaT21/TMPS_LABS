package interfaces

import composite.Product
import databases.BookDatabase
import models.Book

interface IBookManager {
    fun addBook(bookDatabase: BookDatabase, product: Product)
    fun removeBook(bookDatabase: BookDatabase, product: Product)
}