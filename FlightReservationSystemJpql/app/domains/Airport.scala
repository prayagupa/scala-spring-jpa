package domains

import java.util
import javax.persistence.OneToMany

/**
 * Created by prayagupd
 * on 6/25/15
 */

class Airport(name1 : String, city1 : String, country1 : String, airportCode1 : String) {
  val name        : String = name1
  val city        : String = city1
  val country     : String = country1
  val airportCode : String = airportCode1

  def this() = this (null, null, null, null)

  @OneToMany(mappedBy = "origin")
  val origins : util.List[Flight] = new util.ArrayList[Flight]()

  @OneToMany(mappedBy = "destination")
  val destinations : util.List[Flight] = new util.ArrayList[Flight]()
}
