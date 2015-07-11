package domains

import java.sql.Timestamp
import java.util.Date
import javax.persistence._

/**
 * Created by prayagupd
 * on 6/25/15.
 */

@Entity
class Flight(flightNumber1 : String, departDate1 : Date, departTime1 : Long, arrivalDate1 : Date, arrivalTime1 : Long) {
  val flightNumber : String = flightNumber1

  @Temporal(TemporalType.TIMESTAMP)
  val departDate : Date = departDate1
  val departTime : Long = departTime1

  @Temporal(TemporalType.TIMESTAMP)
  val arrivalDate : Date = arrivalDate1
  val arrivalTime : Long = arrivalTime1

  @ManyToOne
  @JoinColumn(name="originId")
  var origin : Airport = _
  
  @ManyToOne
  @JoinColumn(name="destinationId")
  var destination : Airport = _

  @ManyToOne
  @JoinColumn(name="airplaneSerialNumber")
  var airplane : Airplane = _

  def this() = this (null, null, 0, null, 0)
}
