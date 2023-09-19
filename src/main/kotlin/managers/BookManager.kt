package managers

import models.Book
import databases.BookDatabase

interface IBookManager {
    fun addBook(bookDatabase: BookDatabase, book: Book)
    fun removeBook(bookDatabase: BookDatabase, book: Book)
}

class BookManager: IBookManager {
    override fun addBook(bookDatabase: BookDatabase, book: Book) {
        bookDatabase.addBook(book)
    }

    override fun removeBook(bookDatabase: BookDatabase, book: Book) {
        bookDatabase.removeBook(book)
    }
}