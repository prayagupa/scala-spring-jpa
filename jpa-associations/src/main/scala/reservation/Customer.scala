package reservation

import java.util
import javax.persistence._

/**
 * unidirectional @OneToMany
  * http://blog.mirkosertic.de/scalastuff/scalawithjpa
  * Created by prayagupd
  * on 6/24/15.
  */

@Entity
class Customer(dname : String) {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   var id : Int = _

   var name : String = dname

   @OneToMany(cascade = Array(CascadeType.ALL),
              targetEntity = classOf[Reservation],
              fetch = FetchType.LAZY)
   var reservations : java.util.List[Reservation] = new util.ArrayList[Reservation]()

   def this() = this (null)

   def addReservation(reservation : Reservation) {
     reservations.add(reservation)
   }

   override def toString = id + " = " + name + " " + name
 }
