package ui

import adapter.MagazineAdapter
import builders.ChildBookBuilder
import databases.BookDatabase
import decorators.*
import interfaces.*
import models.Magazine
import composite.Collection


class AdminPage(private val idGenerator: IIdGenerator, private val bookManager : IBookManager, private val inventoryManager : IInventoryManager) : IAdminPage, IInventoryViewer, IInventoryAdder, ILogout {

    override fun run(user: User) {
        println("Hello ${user.username}!")
    }

    override fun viewInventory(bookDatabase: BookDatabase) {
        println("View Inventory")
        inventoryManager.seeInventory(bookDatabase)
    }
    override fun addInventory(productInfo: Array<Any>, bookDatabase: BookDatabase) {
        println("Add to Inventory")
        //TODO: Choose book or magazine or childbook ...
        val bookIn = ChildBookBuilder().setId(idGenerator.generateId())
            .setTitle(productInfo[0] as String)
            .setAuthor(productInfo[1] as String)
            .setGenre(productInfo[2] as String)
            .setLanguage(productInfo[3] as String)
            .setPrice(productInfo[4] as Double)
            .setNumberOfPages(productInfo[5] as Int)
            .setQuantity(productInfo[6] as Int)
            .setInStock(productInfo[7] as Boolean)
            .setAgeRate(productInfo[8] as Int)
            .build()
        bookIn.display()
        bookManager.addBook(bookDatabase, bookIn)
        println("Add magazine to inventory")
        val magazine = Magazine(idGenerator.generateId(),
            productInfo[0] as String,
            productInfo[1] as String,
            productInfo[2] as String,
            productInfo[3] as String,
            productInfo[4] as Double,
            productInfo[5] as Int,
            productInfo[6] as Int,
            productInfo[7] as Boolean,
            productInfo[8] as Int)
        val magazine_b = MagazineAdapter(magazine)
        magazine_b.displayBook()
        //TODO: Add in customer page to choose if wrapped and so on
        val bookCopy = bookIn.clone()

        val giftWrappedBook =  GiftWrap(bookCopy)
        println("This is a gift-wrapped copy of the book")
        giftWrappedBook.display()

        val signedBook = Signed(bookCopy)
        println("This is a signed copy of the book")
        signedBook.display()

        val superBook = Note(Signed(giftWrappedBook), "Stas")
        println("This is a signed and gift-wrapped copy of the book")
        superBook.display()

        //TODO: Add to choose if add book or collection
        val collection = Collection("My collection")
        collection.add(bookIn)
        collection.add(signedBook)
        collection.add(giftWrappedBook)
        collection.display()
    }

    override fun logout(user: User) {
        println("Logout")
        println("Bye, ${user.username}!")
    }
}

// Interface Segregation Principle
// The AdminPage class implements the IInventoryViewer, IInventoryAdder, and ILogout interfaces.