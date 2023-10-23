package interfaces

interface IUserDatabase {
    fun login(username: String, password: String): User?
    fun addUser(user: User)
}