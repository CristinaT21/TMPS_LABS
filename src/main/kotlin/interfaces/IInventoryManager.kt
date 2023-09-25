package interfaces

interface IInventoryManager {
    fun run(){}
    fun seeInventory(bookDatabase: IBookDatabase){}
}