package models

import interfaces.User

class Customer(username: String, password: String): User(username, password){
    override fun clone(): User {
        return Customer(username, password)
    }
}