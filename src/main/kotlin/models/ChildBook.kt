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
    override val ageRate: Int,
    override val description: String
): Book(id, title, author, genre, language, price, numberOfPages, quantity, inStock, ageRate, description)
{

    override fun displayBook() {
        super.displayBook()
        println("This is a child book")
    }
}