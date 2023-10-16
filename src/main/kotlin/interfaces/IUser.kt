package interfaces

abstract class User(username: String, passwords: String){
    var username: String = username
    var password: String = passwords
    abstract fun clone(): User
}