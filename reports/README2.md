# Topic: *Creational Patterns*

Author: *Țărnă Cristina*
----
## Objectives:
1.Study and understand the Creational Design Patterns
2.Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
3. Use some creational design patterns in your project.
## Theory:
reational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

## Main task:
 Implement 4 creational design patterns in your project.
 
# Implementation description:
1. Singleton
2. Factory
3. Builder
4. Prototype

## Code logic
1. Singleton - only one instance of a class
```kotlin
object IdGenerator: IIdGenerator 
```

2. Factory - creates objects without exposing the instantiation logic to the client and refers to the newly created object through a common interface
```kotlin
object UserFactory {
    fun createUser(type: String, username: String, password: String): User {
        return when (type) {
            "admin" -> Admin(username, password)
            "customer" -> Customer(username, password)
            else -> throw IllegalArgumentException("Invalid user type")
        }
    }
}
```

3. Builder - separates the construction of a complex object from its representation so that the same construction process can create different representations
```kotlin
class BookBuilder: IBookBuilder {
    ...
    override fun build() = Book(id, title, author, genre, language, price, numberOfPages, quantity, inStock, ageRate)

}
```

4. Prototype - creates objects by cloning an existing object
```kotlin
interface Prototype {
    fun clone(): Prototype
}
```
```kotlin
fun clone(): Book{
    return copy(this, this.id)
}

```