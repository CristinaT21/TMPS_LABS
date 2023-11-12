package strategy

import interfaces.DiscountStrategy

class PercentageDiscountStrategy(private val percentage: Double) : DiscountStrategy {
    init {
        require(percentage >= 0.0 && percentage <= 100.0) { "Percentage should be between 0 and 100." }
    }

    override fun applyDiscount(price: Double): Double {
        val discountAmount = price * (percentage / 100.0)
        return price - discountAmount
    }
}