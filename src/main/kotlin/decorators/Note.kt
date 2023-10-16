package decorators

import interfaces.User
import models.Book

class Note(book: Book, val name: String): Book(book.id, book.title, book.author, book.genre, book.language, book.price , book.numberOfPages, book.quantity, book.inStock, book.ageRate, book.description) {
    override val price: Double
        get() = super.price + 7.0
    override val description: String
        get() = super.description  + "\n This is a gift for " + name + "!"

}