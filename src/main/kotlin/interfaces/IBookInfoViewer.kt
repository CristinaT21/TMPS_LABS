package interfaces

import databases.BookDatabase

interface IBookInfoViewer {
    fun viewBookInfo(bookDatabase: BookDatabase){}
}