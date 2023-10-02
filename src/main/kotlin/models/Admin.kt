package models

import interfaces.User

class Admin(override val username: String, override val password: String): User() {
}