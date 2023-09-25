package interfaces

import databases.BookDatabase
import models.Book

interface IBookManager {
    fun addBook(bookDatabase: BookDatabase, book: Book)
    fun removeBook(bookDatabase: BookDatabase, book: Book)
}