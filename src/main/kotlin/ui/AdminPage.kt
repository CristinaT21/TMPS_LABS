package ui

import builders.ChildBookBuilder
import databases.BookDatabase
import decorators.GiftWrap
import decorators.Note
import decorators.Signed
import interfaces.*
import interfaces.User


class AdminPage(val idGenerator: IIdGenerator, val bookManager : IBookManager, val inventoryManager : IInventoryManager) : IAdminPage, IInventoryViewer, IInventoryAdder, ILogout {

    override fun run(user: User) {
        println("Hello ${user.username}!")
    }

    override fun viewInventory(bookDatabase: BookDatabase) {
        println("View Inventory")
        inventoryManager.seeInventory(bookDatabase)
    }
    override fun addInventory(bookInfo: Array<Any>, bookDatabase: BookDatabase) {
        println("Add to Inventory")
        val bookIn = ChildBookBuilder().setId(idGenerator.generateId())
            .setTitle(bookInfo[0] as String)
            .setAuthor(bookInfo[1] as String)
            .setGenre(bookInfo[2] as String)
            .setLanguage(bookInfo[3] as String)
            .setPrice(bookInfo[4] as Double)
            .setNumberOfPages(bookInfo[5] as Int)
            .setQuantity(bookInfo[6] as Int)
            .setInStock(bookInfo[7] as Boolean)
            .setAgeRate(bookInfo[8] as Int)
            .build()
        bookIn.displayBook()
        bookManager.addBook(bookDatabase, bookIn)
        //TODO: Add in customer page to choose
        val bookCopy = bookIn.clone()

        val giftWrappedBook =  GiftWrap(bookCopy)
        println("This is a gift-wrapped copy of the book")
        giftWrappedBook.displayBook()

        val signedBook = Signed(bookCopy)
        println("This is a signed copy of the book")
        signedBook.displayBook()

        val superBook = Note(Signed(giftWrappedBook), "Stas")
        println("This is a signed and gift-wrapped copy of the book")
        superBook.displayBook()
    }
    override fun logout(user: User) {
        println("Logout")
        println("Bye, ${user.username}!")
    }
}

// Interface Segregation Principle
// The AdminPage class implements the IInventoryViewer, IInventoryAdder, and ILogout interfaces.