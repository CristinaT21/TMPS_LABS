package interfaces

import models.Book


interface IBookDatabase {
    fun addBook(book: Book)
    fun removeBook(book: Book)
    fun seeAllBooks()
    fun countBooks(title: String, author: String): Int
    fun getBooks(): Map<Int, Book>
    fun getBookDetails(title: String, author: String): Book
}