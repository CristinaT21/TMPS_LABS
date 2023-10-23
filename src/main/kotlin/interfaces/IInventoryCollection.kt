package interfaces

import databases.BookDatabase

interface IInventoryCollection {
    fun addCollection(bookDatabase: BookDatabase)
}