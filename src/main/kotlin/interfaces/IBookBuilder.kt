package interfaces

import models.Book

interface IBookBuilder {
    fun setId(id: Int): IBookBuilder
    fun setTitle(title: String): IBookBuilder
    fun setAuthor(author: String): IBookBuilder
    fun setGenre(genre: String): IBookBuilder
    fun setLanguage(language: String): IBookBuilder
    fun setPrice(price: Double): IBookBuilder
    fun setNumberOfPages(numberOfPages: Int): IBookBuilder
    fun setQuantity(quantity: Int): IBookBuilder
    fun setInStock(inStock: Boolean): IBookBuilder
    fun setAgeRate(ageRate: Int): IBookBuilder
    fun build(): Book
}