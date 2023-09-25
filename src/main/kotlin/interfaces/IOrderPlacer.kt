package interfaces

import databases.BookDatabase
import models.Cart
import models.User

interface IOrderPlacer {
    fun placeOrder(cart: Cart, user: User, bookDatabase: BookDatabase){}
}