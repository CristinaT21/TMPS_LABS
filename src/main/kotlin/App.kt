import databases.BookDatabase
import databases.UserDatabase
import models.Cart
import services.AuthService
import ui.UI
import utils.IdGenerator
class App {
    fun run() {
        val app = AppController(ui = UI(idGenerator = IdGenerator()) ,bookDatabase = (BookDatabase(idGenerator = IdGenerator())), authService = AuthService(UserDatabase()), cart = Cart())
        app.run()
    }
}