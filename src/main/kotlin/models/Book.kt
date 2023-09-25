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
    open val inStock: Boolean
) {
    // builder pattern
    class BookBuilder {
        var id: Int = 0
        var title: String = ""
        var author: String = ""
        var genre: String = ""
        var language: String = ""
        var price: Double = 0.0
        var numberOfPages: Int = 0
        var quantity: Int = 1
        var inStock: Boolean = true

        fun id(id: Int) = apply { this.id = id }
        fun title(title: String) = apply { this.title = title }
        fun author(author: String) = apply { this.author = author }
        fun genre(genre: String) = apply { this.genre = genre }
        fun language(language: String) = apply { this.language = language }
        fun price(price: Double) = apply { this.price = price }
        fun numberOfPages(numberOfPages: Int) = apply { this.numberOfPages = numberOfPages }
        fun quantity(quantity: Int) = apply { this.quantity = quantity }
        fun inStock(inStock: Boolean) = apply { this.inStock = inStock }

        fun build(): Book = Book(id, title, author, genre, language, price, numberOfPages, quantity, inStock)
    }

    open fun displayBook() {
        println("Title: $title")
        println("Author: $author")
        println("Genre: $genre")
        println("Language: $language")
        println("Number of Pages: $numberOfPages")
        println("Price: $price")
        println("Left: $quantity")
        println("In Stock: $inStock")
    }

    fun getAvailableQuantity(book: Book): Int {
        return quantity
    }
    fun updateQuantity(book: Book, quantityB: Int) {
        // update quantity of book
        book.quantity = quantityB
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
            inStock = book.inStock
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









