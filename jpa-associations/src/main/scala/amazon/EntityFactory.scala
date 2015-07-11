package amazon

/**
 * Created by prayagupd
 * on 6/24/15.
 */

object EntityFactory {
  def createBook() = {
    val book = new Book("123", "Scala Programming", "Martin Odesky")

    val publisher = new Publisher("Publisher")
    book
  }
}
