package stanford

import java.util
import javax.persistence.{ManyToMany, GeneratedValue, Id}

/**
  * Created by prayagupd
  * on 6/24/15.
  */

class Course(courseNumber1 : String, name1: String) {
   @Id
   @GeneratedValue
   var id : Int = _
   val courseNumber : String = courseNumber1
   val name : String = name1

    @ManyToMany(mappedBy = "courses")
    val students : util.Set[Student] = new util.HashSet[Student]()

    def this() = this (null, null)
 }
