package interfaces

import models.User

interface ILogout {
    fun logout(user: User){}
}