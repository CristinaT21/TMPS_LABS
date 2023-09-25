package interfaces

interface IIdGenerator {
    fun generateId(): Int
    fun currentId(): Int
}