package interfaces

import managers.CartManager

interface ICartViewer {
    fun viewCart(cartManager: CartManager){}
}