import databases.BookDatabase
import interfaces.IAppController
import models.Cart
import models.User
import services.AuthService
import ui.AdminPage
import ui.CustomerPage
import ui.UI


class AppController(val ui: UI, val bookDatabase: BookDatabase, val authService: AuthService, val cart: Cart) : IAppController {
    override fun run() {
        ui.run()
        var user: User? = null
        // login
        while (user == null){
            while (user == null){
                val (name,pass) = ui.validateUser()
                user = authService.auth(name, pass)
                if (user == null){
                    println("Login failed. Invalid credentials.")
                }
            }
        // check if user is customer or admin
        val userType = authService.getUserType(user?: User("",""))
        if (userType == "admin") {
            // create an instance of AdminInterface and call the run method
            user?.let { AdminPage(ui).run(it) }
            AdminPage(ui).chooseAction(user?: User("",""), bookDatabase)
            }
            else if (userType == "customer") {
            // create an instance of CustomerInterface and call the run method
            user?.let { CustomerPage(ui).run(it) }
            CustomerPage(ui).chooseActions(user?: User("",""), bookDatabase, cart)
            }
        }
    }
}