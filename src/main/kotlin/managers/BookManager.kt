package managers

import composite.Product
import databases.BookDatabase
import interfaces.IBookManager

class BookManager: IBookManager {
    override fun addBook(bookDatabase: BookDatabase, product: Product) {
        bookDatabase.addBook(product)
    }

    override fun removeBook(bookDatabase: BookDatabase, product: Product) {
        bookDatabase.removeBook(product)
    }
}