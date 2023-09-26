package interfaces

import models.User

interface IAdminPage {
        fun run(user: User){}

}