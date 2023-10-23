package composite

interface Product {
    val id: Int
    val title: String
    val price: Double
    val author: String
    val language: String
    val numberOfPages: Int
    var quantity: Int
    val inStock: Boolean
    val ageRate: Int
    val description: String
    fun display()
    fun getAvailableQuantity(): Int = quantity
    fun updateQuantity(quantity: Int) {}

}