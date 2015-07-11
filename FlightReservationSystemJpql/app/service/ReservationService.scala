package service

import java.util._
import javax.persistence._

import scala.collection.JavaConversions._

import domains.Flight

/**
 * Created by prayagupd
 * on 6/25/15.
 */

class ReservationService {
  val emf : EntityManagerFactory = Persistence.createEntityManagerFactory("reservation")
  val em : EntityManager = emf.createEntityManager()

  def createFlight() {
    println("==================== Adding Flight ========================")
    var em : EntityManager = emf.createEntityManager()
    val tx : EntityTransaction = em.getTransaction()
    try {
      tx.begin()


      //em.persist(dept)

      tx.commit()
    } catch {
      case e : Throwable =>
        if ((tx != null) && (tx.isActive())) tx.rollback()
    } finally {
      if ((em != null) && (em.isOpen())) em.close()
    }
  }

  def getFlightsByCountry(country : String, capacity : Int) {

    val query : Query = em.createQuery(s"from Flight f where f.origin.country='${country}' and f.airplane.capacity>${capacity}")
    var flights : List[_]= query.getResultList()
    System.out.println("=============== Listing "+flights.size() + " departments ================ ")

    for(f <- flights){
      //println (f.asInstanceOf[Flight].name)
      //println (f.asInstanceOf[Flight])
    }
  }

  def getAirlinesByAirplaneModel(model : String) {

    val query : Query = em.createQuery(s"from Airline f where f.airplane.model>'${model}'")
    var flights : List[_]= query.getResultList()
    System.out.println("=============== Listing "+flights.size() + " departments ================ ")

    for(f <- flights){
      //println (f.asInstanceOf[Flight].name)
      //println (f.asInstanceOf[Flight])
    }
  }

  def getFlightsByAirline(name : String) {

    val query : Query = em.createQuery(s"from Flight f where f.airline.name>'${name}'")
    var flights : List[_]= query.getResultList()
    System.out.println("=============== Listing "+flights.size() + " departments ================ ")

    for(f <- flights){
      //println (f.asInstanceOf[Flight].name)
      //println (f.asInstanceOf[Flight])
    }
  }

  def getFlightsByDepartureDateTime(date : Date, time : Long) {

    val query : Query = em.createQuery(s"from Flight f where f.departureDate='${date}'")
    var flights : List[_]= query.getResultList()
    System.out.println("=============== Listing "+flights.size() + " departments ================ ")

    for(f <- flights){
      //println (f.asInstanceOf[Flight].name)
      //println (f.asInstanceOf[Flight])
    }
  }
}
