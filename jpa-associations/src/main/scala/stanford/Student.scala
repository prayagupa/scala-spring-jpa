package stanford

import java.util
import javax.persistence._

/**
 * Created by prayagupd
 * on 6/24/15.
 */

class Student(firstName: String, lastName: String) {

  @Id
  @GeneratedValue
  var id : Int = _

  var fname : String = firstName
  var lname : String  = lastName

  @ManyToMany(cascade = Array(CascadeType.ALL))
  @JoinTable(name="StudentCourses")
  val courses : util.Set[Course] = new util.HashSet[Course]()

  def this() = this (null, null)
}
