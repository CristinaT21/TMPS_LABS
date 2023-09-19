package services

import models.User
import databases.IUserDatabase

class AuthService (private val database: IUserDatabase){
    // Create a method to authenticate user
    fun auth(username: String, password: String): User? {
        val user = database.login(username, password)
        if (user != null && user.password == password) {
            return user
        }
        return null
    }

    // Create a method to check if user is customer or admin and return user type
    fun getUserType(user: User): String {
        if (user.username == "admin456") {
            return "admin"
        }
        return "customer"
    }
}

//S: The services.AuthService class is primarily responsible for user authentication and user type identification, which suggests it adheres to this principle.
//
//O: The services.AuthService class seems to be open for extension (e.g., new methods could be added to handle new types of users) but closed for modification. Any changes to how users are authenticated or their types are determined should not require changes to the services.AuthService class itself.
//
//I: The services.AuthService class depends on the IUserDatabase interface, which presumably includes the methods it needs and no others. This suggests it adheres to this principle.

//D: The services.AuthService class depends on the abstraction IUserDatabase rather than on a specific implementation of a user database. This makes the services.AuthService class more flexible and easier to maintain.