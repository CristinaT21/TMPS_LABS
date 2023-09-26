package models

import interfaces.IUser

class User(override val username: String, override val password: String): IUser() {
}