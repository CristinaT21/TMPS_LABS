package managers

import databases.IBookDatabase

interface IInventoryManager {
    fun run(){}
    fun seeInventory(bookDatabase: IBookDatabase){}
}

class InventoryManager: IInventoryManager {
    override fun run() {
        println("Welcome to the Inventory!")
    }
    override fun seeInventory(bookDatabase: IBookDatabase) {
        val uniqueBooks = bookDatabase.getBooks().values.toSet()

        for (book in uniqueBooks) {
            val quantity = bookDatabase.countBooks(book.title, book.author)
            println("$quantity exemplar(s) of ${book.title} by ${book.author}")
        }
    }

}