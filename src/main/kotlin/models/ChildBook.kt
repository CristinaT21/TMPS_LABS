package models

import models.Book

class ChildBook(
    override val id: Int,
    override val title: String,
    override val author: String,
    override val genre: String,
    override val language: String,
    override val price: Double,
    override val numberOfPages: Int,
    override val inStock: Boolean,
    val ageRating: Int): Book(id, title, author, genre, language, price, numberOfPages, inStock)
{
    fun isSuitableForAge(age: Int): Boolean {
        return age >= ageRating
    }
}