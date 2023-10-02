package interfaces

import databases.UserDatabase

interface IUserManager {
    fun addUser(user: User, userDatabase: UserDatabase)
}
