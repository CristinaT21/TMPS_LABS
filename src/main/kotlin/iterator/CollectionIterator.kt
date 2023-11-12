package iterator

import composite.Product
import interfaces.ProductIterator


// Concrete Iterator for the Collection
class CollectionIterator(private val products: List<Product>) : ProductIterator {
    private var currentIndex = 0

    override fun hasNext(): Boolean {
        return currentIndex < products.size
    }

    override fun next(): Product {
        if (!hasNext()) {
            throw NoSuchElementException("End of collection")
        }
        val nextProduct = products[currentIndex]
        currentIndex++
        return nextProduct
    }
}