package models


class ChildBook(
    override val id: Int,
    override val title: String,
    override val author: String,
    override val genre: String,
    override val language: String,
    override val price: Double,
    override val numberOfPages: Int,
    override var quantity: Int,
    override val inStock: Boolean,
    private val ageRate: Int): Book(id, title, author, genre, language, price, numberOfPages, quantity, inStock)
{
    override fun displayBook() {
        super.displayBook()
        println("Age Rating: $ageRate")
    }
}