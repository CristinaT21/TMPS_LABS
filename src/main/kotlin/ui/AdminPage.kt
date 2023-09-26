package ui

import databases.BookDatabase
import interfaces.*
import managers.BookManager
import managers.InventoryManager
import models.User
import models.Book
import models.ChildBook
import utils.IdGenerator


class AdminPage(val idGenerator: IIdGenerator) : IAdminPage, IInventoryViewer, IInventoryAdder, ILogout {
    private val bookManager = BookManager()
    private val inventoryManager = InventoryManager()
    override fun run(user: User) {
        println("Hello ${user.username}!")
    }

    override fun viewInventory(bookDatabase: BookDatabase) {
        println("View Inventory")
        inventoryManager.seeInventory(bookDatabase)
    }
    override fun addInventory(bookInfo: Array<Any>, bookDatabase: BookDatabase) {
        println("Add to Inventory")
        // add book to inventory from InventoryManager
        val bookIn = ChildBook(id=(idGenerator.currentId()),
            title=(bookInfo[0] as String),
            author=(bookInfo[1] as String),
            genre=(bookInfo[2] as String),
            language=(bookInfo[3] as String),
            price=(bookInfo[4] as Double),
            numberOfPages=(bookInfo[5] as Int),
            quantity=(bookInfo[6] as Int),
            inStock=(bookInfo[7] as Boolean),
            ageRate=(bookInfo[8] as Int))
        bookIn.displayBook()
        bookManager.addBook(bookDatabase, bookIn)
    }
    override fun logout(user: User) {
        println("Logout")
        println("Bye, ${user.username}!")
    }
}

// Interface Segregation Principle
// The AdminPage class implements the IInventoryViewer, IInventoryAdder, and ILogout interfaces.