package ui

import databases.BookDatabase
import interfaces.IAdminPage
import managers.BookManager
import managers.InventoryManager
import models.User
import interfaces.IInventoryViewer
import interfaces.IInventoryAdder
import interfaces.ILogout


class AdminPage(private val ui: UI) : IAdminPage, IInventoryViewer, IInventoryAdder, ILogout {
    private val bookManager = BookManager()
    private val inventoryManager = InventoryManager()
    override fun run(user: User) {
        println("Hello ${user.username}!")
    }
    fun chooseAction(user: User, bookDatabase: BookDatabase) {
        // loop through choices

        while (true){
            val choice = ui.adminChoice()
            when (choice) {
                1 -> { viewInventory(bookDatabase) }

                2 -> { addInventory(bookDatabase) }

                3 -> { logout(user)
                        break }

                else -> { ui.invalidChoice() }
            }
        }
    }

    override fun viewInventory(bookDatabase: BookDatabase) {
        println("View Inventory")
        inventoryManager.seeInventory(bookDatabase)
    }
    override fun addInventory(bookDatabase: BookDatabase) {
        println("Add to Inventory")
        // add book to inventory from InventoryManager
        val bookIn = ui.addBook()
        bookManager.addBook(bookDatabase, bookIn)
    }
    override fun logout(user: User) {
        println("Logout")
        ui.bye(user)
    }
}

// Interface Segregation Principle
// The AdminPage class implements the IInventoryViewer, IInventoryAdder, and ILogout interfaces.