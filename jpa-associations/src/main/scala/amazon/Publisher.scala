package amazon

import java.util
import javax.persistence.{Id, GeneratedValue}

/**
 * Created by prayagupd
 * on 6/24/15.
 */

class Publisher(name1: String) {
  @Id
  @GeneratedValue
  var id : Int = _
  val name : String = name1


}
