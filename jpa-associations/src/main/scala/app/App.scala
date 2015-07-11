package app

import java.util
import javax.persistence._

import department.{Department, Employee}

import scala.collection.JavaConversions._

/**
 * Created by prayagupd
 * on 6/24/15.
 */

object App {
  var emf : EntityManagerFactory = Persistence.createEntityManagerFactory("cs544")

  def main (args: Array[String]) {
    createDept()
    getDept()
    emf.close()
  }

  def createDept() {
    println("==================== Adding Dept ========================")
    var em : EntityManager = emf.createEntityManager()
    val tx : EntityTransaction = em.getTransaction()
    try {
      tx.begin()

      var dept : Department = new Department()
      dept.name = "Engineering"
      val employee1 = new Employee("Prayag Upd")
      employee1.department = dept
      dept.addEmployee(employee1)
      em.persist(dept)

      tx.commit()
    } catch {
      case e : Throwable =>
        if ((tx != null) && (tx.isActive())) tx.rollback()
    } finally {
      if ((em != null) && (em.isOpen())) em.close()
    }
  }

  def getDept() {
    val em : EntityManager = emf.createEntityManager()
    val query : Query = em.createQuery("from Department d")
    var deptList : util.List[_]= query.getResultList()
    System.out.println("=============== Listing "+deptList.size() + " departments ================ ")

    for(m <- deptList){
      println (m.asInstanceOf[Department].name)
      println (m.asInstanceOf[Department].employees.get(0).name)
    }
  }
}
