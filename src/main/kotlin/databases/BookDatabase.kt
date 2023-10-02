package databases

import interfaces.IBookDatabase
import models.Book
import interfaces.IIdGenerator

class BookDatabase(val idGenerator: IIdGenerator): IBookDatabase {
    // Create a map to store books by their ID
    private val books: MutableMap<Int, Book> = mutableMapOf()

    // Initialize the books map with some sample books
    init {
        // Populate some sample books
        books[idGenerator.generateId()] = Book(
            idGenerator.currentId(),
            "The Hobbit",
            "J.R.R. Tolkien",
            genre = "Fantasy",
            language = "English",
            price = 9.69,
            numberOfPages = 310,
            quantity = 5,
            inStock = true,
            ageRate = 12
        )

        books[idGenerator.generateId()] = Book(
            idGenerator.currentId(),
            "The Fellowship of the Ring",
            "J.R.R. Tolkien",
            genre = "Fantasy",
            language = "English",
            price = 8.59,
            numberOfPages = 300,
            quantity = 3,
            inStock = true,
            ageRate = 13
        )

        books[idGenerator.generateId()] = Book(
            idGenerator.currentId(),
            "The Two Towers",
            "J.R.R. Tolkien",
            genre = "Fantasy",
            language = "English",
            price = 8.99,
            numberOfPages = 320,
            quantity = 2,
            inStock = true,
            ageRate = 14
        )

        books[idGenerator.generateId()] = Book(
            idGenerator.currentId(),
            "The Return of the King",
            "J.R.R. Tolkien",
            genre = "Fantasy",
            language = "English",
            price = 9.99,
            numberOfPages = 400,
            quantity = 1,
            inStock = true,
            ageRate = 15
        )

        books[idGenerator.generateId()] = Book(
            idGenerator.currentId(),
            "The Lion, the Witch, and the Wardrobe",
            "C.S. Lewis",
            genre = "Fantasy",
            language = "English",
            price = 7.99,
            numberOfPages = 240,
            quantity = 1,
            inStock = true,
            ageRate = 10
        )
        books[idGenerator.generateId()] = Book(
            idGenerator.currentId(),
            "Me",
            "CT",
            genre = "Biography",
            language = "English",
            price = 9.99,
            numberOfPages = 210,
            quantity = 5,
            inStock = true,
            ageRate = 18
        )
    }

    override fun addBook(book: Book) {
        // add book to inventory
        val bookId = idGenerator.generateId()
        books[bookId] = book.copy(book, bookId)
        println("${book.title} by ${book.author} added to inventory.")
    }
    override fun removeBook(book: Book) {
        val removedBook = books.remove(book.id)
        if (removedBook != null) {
            println("models.Book removed with ID ${book.id}.")
             // Decrement currentId when a book is removed
        } else {
            println("models.Book with ID ${book.id} not found.")
            }
    }
    override fun seeAllBooks()  {
        println("List of Books")
        for (book in books.values){
            println("${book.title} by ${book.author}")
        }
    }
    override fun getBooks(): Map<Int, Book> {
        return books
    }
    override fun getBookDetails(title: String, author: String): Book? {
        return books.values.find { it.title == title && it.author == author }
    }
}

//S - responsible for managing the inventory
//O - can create a subclass, but not change existing ones to add new features
//L -  The BookDatabase class implements the IBookDatabase interface, so an
// instance of BookDatabase could be replaced with any other class that
// implements IBookDatabase without affecting the correctness of the program.
//I - an implementer of this interface, isn't forced to depend on methods it doesn't use.
//D - It depends on IIdGenerator abstraction, not on concrete classes.