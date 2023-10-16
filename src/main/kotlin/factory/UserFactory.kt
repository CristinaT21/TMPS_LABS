package factory

import AppController
import interfaces.User
import models.Admin
import models.Customer

object UserFactory {
    fun createUser(type: String, username: String, password: String): User {
        return when (type) {
            in AppController.Companion.userFactories.keys -> AppController.Companion.userFactories[type]?.invoke(username, password)!!
            else -> throw IllegalArgumentException("Invalid user type")
        }
    }
}
// dictionar