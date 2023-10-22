package models

import composite.Product

open class Magazine(
    open val id: Int,
    open val title: String,
    open val author: String,
    open val topic: String,
    open val language: String,
    override val price: Double,
    open val numberOfPages: Int,
    open var quantity: Int,
    open val inStock: Boolean,
    open val ageRate: Int,
    open val description: String = ""
): Product {
    override fun display() {
        println("Title: $title")
        println("Author: $author")
        println("Topic: $topic")
        println("Language: $language")
        println("Number of Pages: $numberOfPages")
        println("Price: $price")
        println("Left: $quantity")
        println("In Stock: $inStock")
        println("Age Rating: $ageRate")
        println("Description: $description")
    }
    override fun getAvailableQuantity(): Int {
        return quantity
    }

    override fun updateQuantity(quantityB: Int) {
        // update quantity of book
        quantity = quantityB
    }
    // prototype pattern
    fun clone(): Magazine{
        return copy(this, this.id)
    }
    // data class methods
    fun copy(magazine: Magazine, magazineId: Int): Magazine {
        // create copy of book of specific id
        return Magazine(
            id = magazineId,
            title = magazine.title,
            author = magazine.author,
            topic = magazine.topic,
            language = magazine.language,
            price = magazine.price,
            numberOfPages = magazine.numberOfPages,
            quantity = magazine.quantity,
            inStock = magazine.inStock,
            ageRate = magazine.ageRate,
            description = magazine.description
        )
    }
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Magazine
        if (id != other.id) return false
        return true
    }
    override fun hashCode(): Int{
        return id
    }
}