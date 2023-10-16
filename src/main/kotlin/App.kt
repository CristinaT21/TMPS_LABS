import databases.BookDatabase
import databases.UserDatabase
import factory.UserFactory
import managers.BookManager
import managers.CartManager
import managers.InventoryManager
import models.Cart
import services.AuthService
import ui.AdminPage
import ui.CustomerPage
import ui.UI
import utils.IdGenerator
class App {
    fun run() {
        val app = AppController(ui = UI(), bookDatabase = (BookDatabase(idGenerator = IdGenerator)), authService = AuthService(UserDatabase()), cart = Cart, adminPage = AdminPage(IdGenerator, BookManager(), InventoryManager()), customerPage = CustomerPage(UI(), CartManager(Cart)), userFactory = UserFactory, userDatabase = UserDatabase())
        app.run()
    }
}