import databases.BookDatabase
import interfaces.*
import managers.CartManager
import models.Cart
import models.User
import services.AuthService
import ui.AdminPage
import ui.CustomerPage
import ui.UI
import utils.IdGenerator


class AppController(val ui: UI, val bookDatabase: BookDatabase, val authService: AuthService, val cart: Cart, val adminPage: AdminPage, val customerPage: CustomerPage) : IAppController {
    override fun run() {
        var exit = false
        while (!exit) {
            ui.run()
            var user: User? = null
            // login
            while (user == null) {
                while (user == null) {
                    val (name, pass) = ui.validateUser()
                    user = authService.auth(name, pass)
                    if (user == null) {
                        println("Login failed. Invalid credentials.")
                    }
                }
                // check if user is customer or admin
                val userType = authService.getUserType(user ?: User("", ""))
                // if (user is Admin) {
                if (userType == "admin") {
                    // create an instance of AdminInterface and call the run method
                    user?.let { AdminPage(IdGenerator).run(it) }
                    chooseAction(user ?: User("", ""), bookDatabase)
                } else if (userType == "customer") {
                    // create an instance of CustomerInterface and call the run method
                    user?.let { CustomerPage(ui, CartManager(cart)).run(it) }
                    chooseActions(user ?: User("", ""), bookDatabase, cart)
                }
                // ask if user wants to exit or switch user
                exit = ui.askExitOrSwitchUser()
            }
        }
    }
    fun chooseActions(user: User, bookDatabase: BookDatabase, cart: Cart){
        // loop through choices
        val cartManager = CartManager(cart)
        while (true) {
            val choice = ui.customerChoice()
            when (choice) {
                1 -> { customerPage.viewInventory(bookDatabase) }
                2 -> { customerPage.viewBookInfo(bookDatabase) }
                3 -> { customerPage.addToCart(cartManager, bookDatabase) }
                4 -> { customerPage.removeFromCart(cartManager, bookDatabase) }
                5 -> { customerPage.viewCart(cartManager) }
                6 -> { customerPage.placeOrder(cart, user, bookDatabase) }
                7 -> { customerPage.logout(user)
                    break  }
                else -> { ui.invalidChoice() }
            }
        }
    }
    fun chooseAction(user: User, bookDatabase: BookDatabase) {
        // loop through choices

        while (true) {
            val choice = ui.adminChoice()
            when (choice) {
                1 -> {
                    adminPage.viewInventory(bookDatabase)
                }

                2 -> {
                    adminPage.addInventory(ui.addBookInfo(), bookDatabase)
                }

                3 -> {
                    adminPage.logout(user)
                    break
                }

                else -> {
                    ui.invalidChoice()
                }
            }
        }
    }

}