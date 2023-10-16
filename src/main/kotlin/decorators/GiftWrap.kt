package decorators

import models.Book


class GiftWrap(book: Book): Book(book.id, book.title, book.author, book.genre, book.language, book.price , book.numberOfPages, book.quantity, book.inStock, book.ageRate, book.description) {
    override val price: Double
        get() = super.price + 5.0
    override val description: String
        get() = super.description + "\n Gift-Wrapped! "
}
