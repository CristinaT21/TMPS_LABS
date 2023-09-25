package managers

import models.Book
import databases.BookDatabase
import interfaces.IBookManager

class BookManager: IBookManager {
    override fun addBook(bookDatabase: BookDatabase, book: Book) {
        bookDatabase.addBook(book)
    }

    override fun removeBook(bookDatabase: BookDatabase, book: Book) {
        bookDatabase.removeBook(book)
    }
}