package factory

import interfaces.User
import models.Admin
import models.Customer

object UserFactory {
    fun createUser(type: String, username: String, password: String): User {
        return when (type) {
            "admin" -> Admin(username, password)
            "customer" -> Customer(username, password)
            else -> throw IllegalArgumentException("Invalid user type")
        }
    }
}