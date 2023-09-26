package interfaces
import databases.BookDatabase

interface IInventoryAdder {
    fun addInventory(bookInfo: Array<Any>, bookDatabase: BookDatabase){}
}