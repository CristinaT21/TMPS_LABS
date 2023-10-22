package composite

class Collection(val name: String, private val products: MutableList<Product> = mutableListOf()): Product{
    override val price: Double
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
}