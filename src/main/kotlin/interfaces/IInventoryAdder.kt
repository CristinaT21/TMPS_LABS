package interfaces
import databases.BookDatabase

interface IInventoryAdder {
    fun addInventory(productInfo: Array<Any>, bookDatabase: BookDatabase){}
}