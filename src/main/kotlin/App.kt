import databases.BookDatabase
import databases.UserDatabase
import models.User
import services.AuthService
import ui.AdminPage
import ui.CustomerPage
import ui.UI
import utils.IdGenerator

interface IApp {
    fun run()
}

class App(val bookDatabase: BookDatabase) : IApp {
    override fun run() {
        val ui = UI(idGenerator = IdGenerator())
        ui.run()
        var user: User? = null
        val authService = AuthService(UserDatabase())
        while (user == null){
            val (name,pass) = ui.validateUser()
            user = authService.auth(name, pass)
            if (user == null){
                println("Login failed. Invalid credentials.")
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
            user?.let { CustomerPage().run(it) }
        }


//        if (user != null) {
//            userActions.viewCatalog(user)
//            userActions.addToCatalog(user)
//            userActions.viewOrders(user)
//            userActions.placeOrder(user)
        }
    }
}