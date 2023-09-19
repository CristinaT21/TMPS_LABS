package ui

import models.User

interface ICustomerPage {
    fun run(user: User){}
}

class CustomerPage: ICustomerPage {
    override fun run(user: User) {
        println("Hello ${user.username}!")
    }
}