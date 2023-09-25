package utils

import interfaces.IIdGenerator


class IdGenerator: IIdGenerator {
    private var currentId = 1

    override fun generateId(): Int {
        return currentId++
    }

    override fun currentId(): Int {
        return currentId
    }
}