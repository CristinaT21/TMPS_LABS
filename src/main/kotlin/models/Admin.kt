package models

import interfaces.User

class Admin(username : String, password: String) : User(username, password){
    override fun clone(): User {
        return Admin(username, password)
    }
}