package managers

import databases.UserDatabase
import factory.UserFactory
import interfaces.IUserManager
import interfaces.User

class UserManager: IUserManager {
    override fun addUser(user: User, userDatabase: UserDatabase) {
        userDatabase.addUser(user)
    }
}
