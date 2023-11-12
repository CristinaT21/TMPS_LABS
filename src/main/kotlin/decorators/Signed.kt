package decorators

import models.Book

class Signed(book: Book): Book(book.id, book.title, book.author, book.genre, book.language, book.price , book.numberOfPages, book.quantity, book.inStock, book.ageRate, book.description) {
    override var price: Double = 0.0
        get() = super.price + 10.0
    override val description: String
        get() = super.description + " \n Signed by " + super.author + "!"
}