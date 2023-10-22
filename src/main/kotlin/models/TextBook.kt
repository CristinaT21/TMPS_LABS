package models


class TextBook(
    override val id: Int,
    override val title: String,
    override val author: String,
    override val genre: String,
    override val language: String,
    override val price: Double,
    override val numberOfPages: Int,
    override var quantity: Int,
    override val inStock: Boolean,
    override val ageRate: Int): Book(id, title, author, genre, language, price, numberOfPages, quantity, inStock, ageRate)
{
    override fun display() {
        super.display()
        println("This is a text book")
    }
}