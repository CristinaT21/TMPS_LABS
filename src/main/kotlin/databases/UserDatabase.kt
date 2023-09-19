package databases

import models.User

interface IUserDatabase {
    fun login(username: String, password: String): User?
}
class UserDatabase : IUserDatabase {
    // create a user database to be accessed by the services.AuthService
    private val users: MutableMap<String, User> = mutableMapOf()

    // Initialize the users map with some sample users
    init {
        // Populate some sample users (in a real app, this data would come from a database)
        users["customer123"] = User("customer123", "password123")
        users["admin456"] = User("admin456", "adminPassword")
    }
    override fun login(username: String, password: String): User? {
        val user = users[username]
        if (user != null && user.password == password) {
            return user
        }
        return null
    }

}