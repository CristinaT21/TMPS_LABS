package composite

import interfaces.IIdGenerator
import interfaces.ProductIterator
import iterator.CollectionIterator

class Collection(val name: String, private val products: MutableList<Product> = mutableListOf(), idGenerator: IIdGenerator): Product{
    override val id: Int = idGenerator.generateId()
    override val title: String = name
    override val author: String = ""
    val genre: String = ""
    override val language: String = ""
    override val numberOfPages: Int = 0
    override var quantity: Int = 1
    override val inStock: Boolean = false
    override val ageRate: Int = 0
    override val description: String = ""
    override var price: Double = 0.0
        get() = products.sumOf { it.price }

    fun add(product: Product){
        products.add(product)
    }
    fun remove(product: Product){
        products.remove(product)
    }
    override fun display() {
        println("Collection: $name")
        products.forEach { it.display() }
    }
    override fun getAvailableQuantity(): Int {
        return products.sumOf { it.getAvailableQuantity() }
    }
    // Create an iterator for the collection
    fun createIterator(): ProductIterator {
        return CollectionIterator(products)
    }
}