package models

import composite.Product
object Cart {
    val items: MutableMap<Product, Int> = mutableMapOf()
}