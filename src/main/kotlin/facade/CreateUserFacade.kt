package facade

import databases.UserDatabase
import factory.UserFactory
import interfaces.IUserDatabase
import interfaces.User
import ui.UI

class CreateUserFacade(private val ui: UI, private val userFactory: UserFactory, private val userDatabase: IUserDatabase) {
    fun addUser(): User {
        val(name, pass) = ui.validateUser()
        val user = userFactory.createUser("customer", name, pass)
        println("User created successfully.")
        // add user to database
        userDatabase.addUser(user)
        return user
    }
}