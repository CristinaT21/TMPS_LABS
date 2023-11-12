# Topic: *Behavioural Design Patterns*

Author: *Țărnă Cristina*
------
## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.
## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement 3 behavioural design patterns.__


&ensp; &ensp; Some examples of from this category of design patterns are:

* Chain of Responsibility
*  


## Chain of Responsibility
```python
 
```
I adapted the Magazine class to the Book class, because they have the same attributes, but different names. I used the Adapter pattern to make the Magazine class compatible with the Book class.

## Composite
I created an interface Product, which is implemented by the Book and Magazine classes. 
I used the Composite pattern to create a list of products, which can contain both books and magazines.
```python
class Collection(val name: String, private val products: MutableList<Product> = mutableListOf(), idGenerator: IIdGenerator): Product{
    fun add(product: Product){
        products.add(product)
    }
}
```
## Decorator
I used the Decorator pattern to add a new functionality to the Book class. I created the posibility for a book to be signed by the author, wrapped or contain a note.

```python
class Note(book: Book, val name: String): Book(book.id, book.title, book.author, book.genre, book.language, book.price , book.numberOfPages, book.quantity, book.inStock, book.ageRate, book.description) {
    override val price: Double
        get() = super.price + 7.0
    override val description: String
        get() = super.description  + "\n This is a gift for " + name + "!"
}
```

## Facade
I used the Facade pattern to create a CreateUserFacade class that will be used to access the functionalities of the system. 
```python
class CreateUserFacade(private val ui: UI, private val userFactory: UserFactory, private val userDatabase: IUserDatabase) {
    fun addUser(): User {
        val(name, pass) = ui.validateUser()
        val user = userFactory.createUser("customer", name, pass)
        println("User created successfully.")
        // add user to database
        userDatabase.addUser(user)
        return user
    }
}
```
## Conclusions:
In this laboratory work I studied and implemented 3 behavioural design patterns.