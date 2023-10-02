package services

import databases.UserDatabase
import factory.UserFactory

class UserService(private val userDatabase: UserDatabase, private val userFactory : UserFactory) {


    fun registerUser(type: String, username: String, password: String) {
        val user = userFactory.createUser(type, username, password)
        userDatabase.addUser(user)
    }
}