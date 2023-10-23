package adapter

import models.Book
import models.Magazine

class MagazineAdapter(private val magazine: Magazine) : Book(id = magazine.id, title = magazine.title, author = magazine.author, genre = magazine.topic, language = magazine.language, price = magazine.price, numberOfPages = magazine.numberOfPages, quantity = magazine.quantity, inStock = magazine.inStock, ageRate = magazine.ageRate, description = magazine.description) {

    override fun display() {
        magazine.display()
    }
}