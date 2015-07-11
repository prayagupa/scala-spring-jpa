package reservation

import javax.persistence._

/**
  * Created by prayagupd
  * on 6/24/15.
  */

@Entity
class Reservation(ename : String) {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   var employeeNumber : Int = _

   val name : String = ename

//   @ManyToOne
//   var customer : Customer = _

   def this() = this (null)
 }
