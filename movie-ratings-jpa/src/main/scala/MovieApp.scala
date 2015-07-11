import java.util
import javax.persistence._
import scala.language.implicitConversions._
import scala.collection.JavaConversions._

import movies.domains.{Artist, Movie}

/**
 * Created by prayagupd
 * on 6/24/15.
 */

object MovieApp {
  var emf : EntityManagerFactory = Persistence.createEntityManagerFactory("cs544")

  def main (args: Array[String]) {
    addMovies()
    printMoviesReport()
    emf.close()
  }

  def addMovies() {
    println("==================== Adding Movie ========================")
    var em : EntityManager = emf.createEntityManager()
    val tx : EntityTransaction = em.getTransaction()
    try {
      tx.begin();

      var movie : Movie = new Movie()
      var bradPitt : Artist = new Artist()
      bradPitt.setName("Brad Pitt")
      bradPitt.setMovieCharacter("Actor")

      var morgan : Artist = new Artist()
      morgan.setName("Morgan Freeman")
      morgan.setMovieCharacter("Actor")

      movie.setName("Seven")
      movie.setCategory("Thriller")
      movie.setComment("Thriller movie")
      movie.addArtist(bradPitt)
      movie.addArtist(morgan)
      movie.setRating(10)
      println("=================== Persisting movie =================== ")
      em.persist(movie)

      tx.commit()
    } catch {
      case e : Throwable =>
        if ((tx != null) && (tx.isActive())) tx.rollback()
    } finally {
      if ((em != null) && (em.isOpen())) em.close()
    }
  }

  def printMoviesReport() {
    val em : EntityManager = emf.createEntityManager()
    val query : Query = em.createQuery("from Movie m")
    var movieList : util.List[_]= query.getResultList()
    System.out.println("=============== Listing "+movieList.size() + " movies ================ ")

    for(m <- movieList){
        println (m.asInstanceOf[Movie].getName)
    }
  }
}
