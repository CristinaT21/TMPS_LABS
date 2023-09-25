package interfaces
import databases.BookDatabase

interface IInventoryAdder {
    fun addInventory(bookDatabase: BookDatabase){}
}