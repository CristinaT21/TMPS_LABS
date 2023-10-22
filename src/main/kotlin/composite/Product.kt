package composite

interface Product {
    val price: Double
    fun display()
    fun getAvailableQuantity(): Int = 0
    fun getTitle(): String = ""
    fun updateQuantity(quantity: Int) {}
}