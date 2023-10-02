package models

open class Book(
    open val id: Int,
    open val title: String,
    open val author: String,
    open val genre: String,
    open val language: String,
    open val price: Double,
    open val numberOfPages: Int,
    open var quantity: Int,
    open val inStock: Boolean,
    open val ageRate: Int
) {

    open fun displayBook() {
        println("Title: $title")
        println("Author: $author")
        println("Genre: $genre")
        println("Language: $language")
        println("Number of Pages: $numberOfPages")
        println("Price: $price")
        println("Left: $quantity")
        println("In Stock: $inStock")
        println("Age Rating: $ageRate")
    }

    fun getAvailableQuantity(book: Book): Int {
        return quantity
    }
    fun updateQuantity(book: Book, quantityB: Int) {
        // update quantity of book
        book.quantity = quantityB
    }
    // prototype pattern
    fun clone(): Book{
        return copy(this, this.id)
    }
    // data class methods
    fun copy(book: Book, bookId: Int): Book {
        // create copy of book of specific id
        return Book(
            id = bookId,
            title = book.title,
            author = book.author,
            genre = book.genre,
            language = book.language,
            price = book.price,
            numberOfPages = book.numberOfPages,
            quantity = book.quantity,
            inStock = book.inStock,
            ageRate = book.ageRate
        )
    }
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (author != other.author) return false

        return true
    }
    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        return result
    }
    override fun toString(): String {
        return "Book(title='$title', author='$author')"
    }
}

//S - responsible for representing a book
//O - new properties could be added to the BookBuilder class.Any changes to how
// books are represented should not require changes to the models.Book class itself.
//D - The models.Book class does not depend on any lower-level modules or concrete implementations









