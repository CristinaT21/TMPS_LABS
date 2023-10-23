package ui

import adapter.MagazineAdapter
import builders.*
import databases.BookDatabase
import decorators.*
import interfaces.*
import models.*
import composite.*


class AdminPage(private val idGenerator: IIdGenerator, private val bookManager : IBookManager, private val inventoryManager : IInventoryManager) : IAdminPage, IInventoryViewer, IInventoryAdder, IInventoryCollection, ILogout {

    override fun run(user: User) {
        println("Hello ${user.username}!")
    }

    override fun viewInventory(bookDatabase: BookDatabase) {
        println("View Inventory")
        inventoryManager.seeInventory(bookDatabase)
    }
    override fun addInventory(productInfo: Array<Any>, bookDatabase: BookDatabase) {
        println("Add to Inventory")
        val productType = chooseProductType()
        when (productType) {
            1 -> {
                val book = BookBuilder().setId(idGenerator.generateId())
                    .setTitle(productInfo[0] as String)
                    .setAuthor(productInfo[1] as String)
                    .setGenre(productInfo[2] as String)
                    .setLanguage(productInfo[3] as String)
                    .setPrice(productInfo[4] as Double)
                    .setNumberOfPages(productInfo[5] as Int)
                    .setQuantity(productInfo[6] as Int)
                    .setInStock(productInfo[7] as Boolean)
                    .build()
                book.display()
                bookManager.addBook(bookDatabase, book)
            }

            2 -> {
                val magazine = Magazine(
                    idGenerator.generateId(),
                    productInfo[0] as String,
                    productInfo[1] as String,
                    productInfo[2] as String,
                    productInfo[3] as String,
                    productInfo[4] as Double,
                    productInfo[5] as Int,
                    productInfo[6] as Int,
                    productInfo[7] as Boolean,
                    productInfo[8] as Int
                )
                val magazine_b = MagazineAdapter(magazine)
                magazine_b.display()
                bookManager.addBook(bookDatabase, magazine_b)
            }

            3 -> {
                val childBook = ChildBookBuilder().setId(idGenerator.generateId())
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
                childBook.display()
                bookManager.addBook(bookDatabase, childBook)
            }

            4 -> {
                val textBook = TextBook(
                    idGenerator.generateId(),
                    productInfo[0] as String,
                    productInfo[1] as String,
                    productInfo[2] as String,
                    productInfo[3] as String,
                    productInfo[4] as Double,
                    productInfo[5] as Int,
                    productInfo[6] as Int,
                    productInfo[7] as Boolean,
                    productInfo[8] as Int
                )
                textBook.display()
                bookManager.addBook(bookDatabase, textBook)
            }

        }
    }

    override fun addCollection(bookDatabase: BookDatabase) {
        println("Add name of collection")
        val name: String = readLine() ?: ""
        val collection = Collection(name, products = mutableListOf(), idGenerator = idGenerator)
        while (true) {
            // add book to collection
            println("Add book to collection. Enter y to continue or n to stop")
            val add: String = readLine() ?: ""
            if (add == "y") {
                println("Enter the title of the book")
                val title: String = readLine() ?: ""
                println("Enter the author of the book")
                val author: String = readLine() ?: ""
                val product: Product = bookDatabase.getBookDetails(title, author)!!
                collection.add(product)
                bookDatabase.removeBook(product)
            }
            else {
                break
            }
        }
        collection.display()
        bookManager.addBook(bookDatabase, collection)

    }

    fun chooseProductType(): Int {
        println("Choose product type")
        println("1. Book")
        println("2. Magazine")
        println("3. Child Book")
        println("4. Text Book")
        return readLine()!!.toInt()
    }
    override fun logout(user: User) {
        println("Logout")
        println("Bye, ${user.username}!")
    }
}

// Interface Segregation Principle
// The AdminPage class implements the IInventoryViewer, IInventoryAdder, and ILogout interfaces.