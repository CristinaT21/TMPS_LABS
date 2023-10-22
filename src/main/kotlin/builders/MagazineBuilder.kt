package builders

import models.Book
import interfaces.IBookBuilder
import models.Magazine

class MagazineBuilder: IBookBuilder {
    var id: Int = 0
    var title: String = ""
    var author: String = ""
    var topic: String = ""
    var language: String = ""
    var price: Double = 0.0
    var numberOfPages: Int = 0
    var quantity: Int = 0
    var inStock: Boolean = false
    var ageRate: Int = 0
    var description: String = ""

    override fun setId(id: Int) = apply { this.id = id }
    override fun setTitle(title: String) = apply { this.title = title }
    override fun setAuthor(author: String) = apply { this.author = author }
    override fun setGenre(topic: String) = apply { this.topic = topic }
    override fun setLanguage(language: String) = apply { this.language = language }
    override fun setPrice(price: Double) = apply { this.price = price }
    override fun setNumberOfPages(numberOfPages: Int) = apply { this.numberOfPages = numberOfPages }
    override fun setQuantity(quantity: Int) = apply { this.quantity = quantity }
    override fun setInStock(inStock: Boolean) = apply { this.inStock = inStock }
    override fun setAgeRate(ageRate: Int) = apply { this.ageRate = ageRate }
    override fun setDescription(description: String) = apply { this.description = description }
    override fun build() = Book(id, title, author, topic, language, price, numberOfPages, quantity, inStock, ageRate, description)



}