package interfaces

import databases.BookDatabase
import models.Cart
import models.Customer

interface IOrderPlacer {
    fun placeOrder(cart: Cart, customer: Customer, bookDatabase: BookDatabase, handlerChain: IHandlerChain, discountStrategy: DiscountStrategy){}
}