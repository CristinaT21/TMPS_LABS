# Topic: *SOLID Principles*

Author: *Țărnă Cristina*
-----
## Objectives:
1. Study SOLID Principles
2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
3. Create a sample project that respects SOLID Principles.

## Theory:
SOLID is a set of five object-oriented design principles intended to make software designs more maintainable, flexible, and easy to understand. The acronym stands for Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle. Each principle addresses a specific aspect of software design, such as the organization of responsibilities, the handling of dependencies, and the design of interfaces. By following these principles, software developers can create more modular, testable, and reusable code that is easier to modify and extend over time. These principles are widely accepted and adopted in the software development community and can be applied to any object-oriented programming language.

## Main tasks:
&ensp; &ensp; __1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

&ensp; &ensp; __2. Select a domain area for the sample project.__

&ensp; &ensp; __3. Define the main involved classes and think about what instantiation mechanisms are needed.__

&ensp; &ensp; __4. Respect SOLID Principles in your project.__

# Implementation description:
## Project domain
- an online book store

## SOLID Principles
- S - all classes have a single responsibility
- O - new methods can be added, without changing the models
- L - class Book is the parent of ChildBook, and it can substitute the parent class without problems 
- I - class depends on the interface, which presumably includes the methods it needs and no others.
- D - class does not depend on any lower-level modules or concrete implementations
#### More detailed information in each file

## Code logic
**Main**.kt
```kotlin
fun main() {
    val app = App()
    app.run()
}
```
**AppController**.kt
```kotlin
class AppController(val ui: UI, val bookDatabase: BookDatabase, val authService: AuthService, val cart: Cart, val adminPage: AdminPage, val customerPage: CustomerPage) : IAppController {..}
```
class AppController inherits from IAppController interface

**BookDatabase**.kt
- These are the methods used in book database
```kotlin
interface IBookDatabase {
    fun addBook(book: Book)
    fun removeBook(book: Book)
    fun seeAllBooks()
    fun getBooks(): Map<Int, Book>
    fun getBookDetails(title: String, author: String): Book
}
```
**UI**.kt takes care of user interaction

**AuthService**.kt - method for authentication of user
```kotlin
class AuthService (private val database: IUserDatabase){
    fun auth(username: String, password: String): User? {
        val user = database.login(username, password)
        if (user != null && user.password == password) {
            return user
        }
        return null
    }
```

**Admin** page is responsible for the actions chosen by admin
```kotlin
class AdminPage(val idGenerator: IIdGenerator) : IAdminPage, IInventoryViewer, IInventoryAdder, ILogout {}
```
AdminPAge depends on interfaces: IAdminPage, IInventoryViewer, IInventoryAdder, ILogout

Manager classes are responsible for adding and deleting objects
```kotlin
interface IBookManager {
    fun addBook(bookDatabase: BookDatabase, book: Book)
    fun removeBook(bookDatabase: BookDatabase, book: Book)
}
```
Note: see rest classes/interfaces in the project
# Results:
```
Welcome to the Bookstore!
Please enter your username:
-> admin456
Please enter your password:
-> adminPassword
Hello admin456!
1. View Inventory
2. Add to Inventory
3. Logout
-> 1
View Inventory
5 exemplar(s) of The Hobbit by J.R.R. Tolkien
3 exemplar(s) of The Fellowship of the Ring by J.R.R. Tolkien
2 exemplar(s) of The Two Towers by J.R.R. Tolkien
1 exemplar(s) of The Return of the King by J.R.R. Tolkien
1 exemplar(s) of The Lion, the Witch, and the Wardrobe by C.S. Lewis
5 exemplar(s) of Me by CT
1. View Inventory
2. Add to Inventory
3. Logout
-> 2
Please enter the title of the book:
-> Hello
Please enter the author of the book:
-> World
Please enter the genre of the book:
-> science
Please enter the language of the book:
-> en
Please enter the price of the book:
-> 13
Please enter the number of pages of the book:
-> 332
Please enter the quantity of the book:
-> 23
Please enter if book in stock:
-> true
Please enter the age rating of the book:
-> 12
Add to Inventory
Title: Hello
Author: World
Genre: science
Language: en
Number of Pages: 332
Price: 13.0
Left: 23
In Stock: true
Age Rating: 12
This is a child book
Hello by World added to inventory.
1. View Inventory
2. Add to Inventory
3. Logout
-> 1
View Inventory
5 exemplar(s) of The Hobbit by J.R.R. Tolkien
3 exemplar(s) of The Fellowship of the Ring by J.R.R. Tolkien
2 exemplar(s) of The Two Towers by J.R.R. Tolkien
1 exemplar(s) of The Return of the King by J.R.R. Tolkien
1 exemplar(s) of The Lion, the Witch, and the Wardrobe by C.S. Lewis
5 exemplar(s) of Me by CT
23 exemplar(s) of Hello by World
1. View Inventory
2. Add to Inventory
3. Logout
-> 3
Logout
Bye, admin456!
Do you want to exit the application or switch user?
1. Exit
2. Switch user
-> 2
Welcome to the Bookstore!
Please enter your username:
-> customer456
Please enter your password:
-> passs
Login failed. Invalid credentials.
Please enter your username:
-> customer123
Please enter your password:
-> password123
Hello customer123!
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 1
View Catalog
List of Books
The Hobbit by J.R.R. Tolkien
The Fellowship of the Ring by J.R.R. Tolkien
The Two Towers by J.R.R. Tolkien
The Return of the King by J.R.R. Tolkien
The Lion, the Witch, and the Wardrobe by C.S. Lewis
Me by CT
Hello by World
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 3
Add to Cart
Please enter the book title:
-> Me
Please enter the book author:
-> CT
Please enter the number of copies:
-> 4
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 3
Add to Cart
Please enter the book title:
-> Hello
Please enter the book author:
-> World
Please enter the number of copies:
-> 10
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 5
View Cart
{Book(title='Me', author='CT')=4, Book(title='Hello', author='World')=10}
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 6
Order
Book(title='Me', author='CT')=4
Book(title='Hello', author='World')=10
Please enter your email:
-> hi@gmail.com
Please enter your address:
-> Home
Please enter true if your cart info is valid:
-> true
Order has been placed successfully. Thank you for your order, customer123!
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 5
View Cart
{}
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 6
Order
Your cart is empty. Please add some books to your cart before placing an order.
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 2
View Book Details
Please enter the book title:
-> Me
Please enter the book author:
-> CT
Title: Me
Author: CT
Genre: Biography
Language: English
Number of Pages: 210
Price: 9.99
Left: 1
In Stock: true
Age Rating: 18
1. View Catalog
2. View Book
3. Add to Cart
4. Remove from Cart
5. View Cart
6. Order
7. Logout
-> 7
Logout
Bye, customer123!
Do you want to exit the application or switch user?
1. Exit
2. Switch user
-> 1
```