package interfaces
import databases.BookDatabase

interface IInventoryViewer {
    fun viewInventory(bookDatabase: BookDatabase){}
}