package builders
import models.Book
import interfaces.IBookBuilder

class BookBuilder: IBookBuilder {
    var id: Int = 0
    var title: String = ""
    var author: String = ""
    var genre: String = ""
    var language: String = ""
    var price: Double = 0.0
    var numberOfPages: Int = 0
    var quantity: Int = 0
    var inStock: Boolean = false
    var ageRate: Int = 0

    override fun setId(id: Int) = apply { this.id = id }
    override fun setTitle(title: String) = apply { this.title = title }
    override fun setAuthor(author: String) = apply { this.author = author }
    override fun setGenre(genre: String) = apply { this.genre = genre }
    override fun setLanguage(language: String) = apply { this.language = language }
    override fun setPrice(price: Double) = apply { this.price = price }
    override fun setNumberOfPages(numberOfPages: Int) = apply { this.numberOfPages = numberOfPages }
    override fun setQuantity(quantity: Int) = apply { this.quantity = quantity }
    override fun setInStock(inStock: Boolean) = apply { this.inStock = inStock }
    override fun setAgeRate(ageRate: Int) = apply { this.ageRate = ageRate }

    override fun build() = Book(id, title, author, genre, language, price, numberOfPages, quantity, inStock, ageRate)
}