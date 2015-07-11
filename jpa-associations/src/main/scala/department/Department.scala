package department

import java.util
import javax.persistence._

/**
 * mysql> select * from Department;
          +----+-------------+
          | id | name        |
          +----+-------------+
          |  1 | Engineering |
          +----+-------------+
 * http://blog.mirkosertic.de/scalastuff/scalawithjpa
 * Created by prayagupd
 * on 6/24/15.
 */

@Entity
class Department(dname : String) {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id : Int = _

  var name : String = dname

  @OneToMany(mappedBy = "department",
             cascade = Array(CascadeType.ALL),
             targetEntity = classOf[Employee],
             fetch = FetchType.LAZY)
  // mappedBy indicates that the entity in this side is the inverse of the relationship,
  // and the owner resides in the "Many" entity
  // http://stackoverflow.com/a/11938290/432903
  // mappedBy ideally should always be used in the Parent side (Dept class) of the bi directional relationship
  var employees : java.util.List[Employee] = new util.ArrayList[Employee]()

  def this() = this (null)

  def addEmployee(emp : Employee) {
    employees.add(emp)
  }

  override def toString = id + " = " + name + " " + name
}
