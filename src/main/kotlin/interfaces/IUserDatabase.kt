package interfaces

import models.User

interface IUserDatabase {
    fun login(username: String, password: String): User?
}