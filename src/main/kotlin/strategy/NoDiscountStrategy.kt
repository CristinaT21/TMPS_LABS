package strategy

import interfaces.DiscountStrategy

class NoDiscountStrategy : DiscountStrategy {
    override fun applyDiscount(price: Double): Double {
        return price
    }
}