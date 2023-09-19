import databases.BookDatabase
import utils.IdGenerator

fun main() {
    val app = App(bookDatabase = (BookDatabase(idGenerator = IdGenerator())))
    app.run()
}

