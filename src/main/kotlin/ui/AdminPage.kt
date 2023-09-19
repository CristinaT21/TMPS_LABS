package ui

import databases.BookDatabase
import managers.BookManager
import managers.InventoryManager
import models.User


interface IAdminPage {
    fun run(user: User){}
}

class AdminPage(private val ui: UI) : IAdminPage {
    override fun run(user: User) {
        println("Hello ${user.username}!")
    }
    fun chooseAction(user: User, bookDatabase: BookDatabase): Int {

        // loop through choices
        var loop = true
        while (loop){
            val choice = ui.adminChoice()
            when (choice) {
                1 -> {
                    println("View Inventory")
                    // print each book and the quantity from InventoryManager
                    InventoryManager().seeInventory(bookDatabase)
                }

                2 -> {
                    println("Add to Inventory")
                    // add book to inventory from InventoryManager
                    val bookIn = ui.addBook()
                    BookManager().addBook(bookDatabase, bookIn)
                }

                3 -> {
                    println("Logout")
                    loop = false
                    ui.bye(user)
                    // logout
                }

                else -> {
                    println("Invalid choice. Please try again.")
                    return chooseAction(user, bookDatabase)
                }
            }
        }
//        return choice
        return 0
    }
}