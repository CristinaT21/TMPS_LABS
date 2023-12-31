import chainOfResponsibility.CreditCardHandler
import chainOfResponsibility.HandlerChain
import chainOfResponsibility.PayPalHandler
import databases.BookDatabase
import databases.UserDatabase
import facade.CreateUserFacade
import factory.UserFactory
import interfaces.*
import managers.BookManager
import managers.CartManager
import managers.InventoryManager
import models.Admin
import models.Cart
import models.Customer
import services.AuthService
import strategy.NoDiscountStrategy
import strategy.PercentageDiscountStrategy
import ui.AdminPage
import ui.CustomerPage
import ui.UI
import utils.IdGenerator


class AppController(val ui: UI, val bookDatabase: BookDatabase, val authService: AuthService, val cart: Cart, val adminPage: AdminPage, val customerPage: CustomerPage, val userFactory: UserFactory, val userDatabase: UserDatabase) : IAppController {
    // create a dictionary of users type
    companion object {
        val payments: List<IPaymentHandler> = listOf(CreditCardHandler(), PayPalHandler())
        val userFactories: Map<String, (String, String) -> User> = mapOf(
            "admin" to ::Admin,
            "customer" to ::Customer
        )
    }
    val handlerChain = HandlerChain()
    override fun run() {
        var exit = false
        while (!exit) {
            ui.run()

            chooseRegisterOrLogin()

            // ask if user wants to exit or switch user
            exit = ui.askExitOrSwitchUser()
            }

    }
    fun chooseRegisterOrLogin() {
        // loop through choices
        while (true) {
            val choice = ui.registerOrLogin()
            when (choice) {
                1 -> { // register user
                    val user = CreateUserFacade(ui, userFactory, userDatabase).addUser()
                    // create an instance of CustomerInterface and call the run method
                    user.let { CustomerPage(ui).run(it)}
                    chooseActions(user as Customer, bookDatabase, this.cart, handlerChain, discountStrategy=PercentageDiscountStrategy(10.0))
                }
                2 -> {
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
                        // choose user type
                        val userType = authService.getUserType(user)
                        when (userType) {
                            "admin" -> {
                                // create an instance of AdminInterface and call the run method
                                user.let { AdminPage(IdGenerator, BookManager(), InventoryManager()).run(it)}
                                chooseAction(user, bookDatabase)

                            }
                            "customer" -> {
                                // create an instance of CustomerInterface and call the run method
                                user.let { CustomerPage(ui).run(it)}
                                chooseActions(user as Customer, bookDatabase, cart, handlerChain, discountStrategy= NoDiscountStrategy())
                            }
                            else -> { ui.invalidChoice() }
                        }
                    }
                }
                0 -> { break }
                else -> { ui.invalidChoice() }
            }
        }
    }
    fun chooseActions(customer: Customer, bookDatabase: BookDatabase, cart: Cart, handlerChain: IHandlerChain, discountStrategy: DiscountStrategy){
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
                6 -> { customerPage.placeOrder(cart, customer, bookDatabase, handlerChain, discountStrategy) }
                7 -> { customerPage.logout(customer)
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
                1 -> { adminPage.viewInventory(bookDatabase)}
                2 -> { adminPage.addInventory(ui.addBookInfo(), bookDatabase)}
                3 -> { adminPage.addCollection(bookDatabase)}

                0 -> { adminPage.logout(user)
                       break
                     }
                else -> { ui.invalidChoice()}
            }
        }
    }
}