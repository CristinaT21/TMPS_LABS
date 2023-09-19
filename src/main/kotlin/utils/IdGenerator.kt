package utils

interface IIdGenerator {
    fun generateId(): Int
    fun currentId(): Int
}

class IdGenerator: IIdGenerator {
    private var currentId = 1

    override fun generateId(): Int {
        return currentId++
    }

    override fun currentId(): Int {
        return currentId
    }
}