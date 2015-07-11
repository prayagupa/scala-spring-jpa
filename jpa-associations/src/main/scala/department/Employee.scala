package department

import javax.persistence._

/**
mysql> desc Employee;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| employeeNumber | int(11)      | NO   | PRI | NULL    | auto_increment |
| version        | int(11)      | NO   |     | NULL    |                |
| name           | varchar(255) | YES  |     | NULL    |                |
| departmentId   | int(11)      | YES  | MUL | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+

 * Created by prayagupd
 * on 6/24/15.
 */

@Entity
class Employee(ename : String) extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var employeeNumber : Int = _

  val name : String = ename

  @ManyToOne
  @JoinColumn(name="departmentId")
  //indicates that this entity is the owner of the relationship
  // (that is: the corresponding table has a column with a foreign key to the referenced table)
  var department : Department = _

  def this() = this (null)
}
