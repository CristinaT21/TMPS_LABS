package interfaces

import models.User

interface ICustomerPage {
    fun run(user: User){}
}