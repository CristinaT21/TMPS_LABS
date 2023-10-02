package databases

import interfaces.User
import interfaces.IUserDatabase
import models.Admin
import models.Customer

class UserDatabase : IUserDatabase {
    // create a user database to be accessed by the services.AuthService
    private val users: MutableMap<String, User> = mutableMapOf()

    // Initialize the users map with some sample users
    init {
        // Populate some sample users (in a real app, this data would come from a database)
        users["customer123"] = Customer("customer123", "password123")
        users["admin456"] = Admin("admin456", "adminPassword")
    }
    fun addUser(user: User) {
        users[user.username] = user
    }
    override fun login(username: String, password: String): User? {
        val user = users[username]
        if (user != null && user.password == password) {
            return user
        }
        return null
    }

}