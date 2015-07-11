package amazon

import java.util
import javax.persistence._

/**
 * Created by prayagupd
 * on 6/24/15.
 */

class Book(isbn1: String, title1: String, author1: String) {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id : Int = _

  var isbn : String  = isbn1
  var title : String = title1
  var author : String = author1

  @ManyToOne(optional = true)
  var publisher : Publisher = _

  def this() = this (null, null, null)
}
