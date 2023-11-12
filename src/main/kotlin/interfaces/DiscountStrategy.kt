package interfaces

interface DiscountStrategy {
    fun applyDiscount(price: Double): Double
}