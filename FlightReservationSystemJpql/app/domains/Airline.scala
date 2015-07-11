package domains

import java.util
import javax.persistence.OneToMany

/**
 * Created by prayagupd
 * on 6/25/15
 */

class Airline(aName : String) {
  val name : String = aName

  @OneToMany(mappedBy = "airline")
  val flights : util.List[Flight] = new util.ArrayList[Flight]()

  def this() = this(null)
}
