package models

import interfaces.User

class Customer(override val username: String, override val password: String): User() {
}