package databases

import composite.Product
import interfaces.IBookDatabase
import models.Book
import interfaces.IIdGenerator

class BookDatabase(val idGenerator: IIdGenerator): IBookDatabase {
    // Create a map to store books by their ID
    private val books: MutableMap<Int, Product> = mutableMapOf()

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
            ageRate = 12,
            description = "The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien. It was published on 21 September 1937 to wide critical acclaim, being nominated for the Carnegie Medal and awarded a prize from the New York Herald Tribune for best juvenile fiction. The book remains popular and is recognized as a classic in children's literature."
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
            ageRate = 13,
            description = "The Fellowship of the Ring is the first of three volumes of the epic novel The Lord of the Rings by the English author J. R. R. Tolkien. It is followed by The Two Towers and The Return of the King. It takes place in the fictional universe of Middle-earth. It was originally published on 29 July 1954 in the United Kingdom."
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
            ageRate = 14,
            description = "The Two Towers is the second volume of J. R. R. Tolkien's high fantasy novel The Lord of the Rings. It is preceded by The Fellowship of the Ring and followed by The Return of the King. Originally published in 1954, the story covers events of the first two volumes of Tolkien's The Lord of the Rings."
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
            ageRate = 15,
            description = "The Return of the King is the third and final volume of J. R. R. Tolkien's The Lord of the Rings, following The Fellowship of the Ring and The Two Towers. The story begins in the kingdom of Gondor, which is soon to be attacked by the Dark Lord Sauron."
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
            ageRate = 10,
            description = "The Lion, the Witch and the Wardrobe is a fantasy novel for children by C. S. Lewis, published by Geoffrey Bles in 1950. It is the first published and best known of seven novels in The Chronicles of Narnia. Among all the author's books, it is also the most widely held in libraries."
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
            ageRate = 18,
            description = "The story of my life."
        )
    }

    override fun addBook(book: Product) {
        // add book to inventory
        val bookId = idGenerator.generateId()
        books[bookId] = book
        println("${book.title} by ${book.author} added to inventory.")
    }
    override fun removeBook(book: Product) {
        val id = book.id
        if (id != null) {
            if (book.quantity > 0) {
                book.quantity--
                }
            else{books.remove(book.id)}
            println("Book removed with ID ${book.id}.")
             // Decrement currentId when a book is removed
        } else {
            println("Book not found.")
            }
    }
    override fun seeAllBooks()  {
        println("List of Books")
        for (book in books.values){
            println("${book.title} by ${book.author}")
        }
    }
    override fun getBooks(): Map<Int, Product> {
        return books
    }
    override fun getBookDetails(title: String, author: String): Product? {
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