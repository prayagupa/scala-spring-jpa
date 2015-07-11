package domains

import java.util
import javax.persistence.{Id, OneToMany, Entity}

/**
 * Created by prayagupd
 * on 6/25/15.
 */

@Entity
class Airplane(serialNumber1 : String, model1 : String, capacity1 : Int) {

  @Id
  val serialNumber : String = serialNumber1
  val model : String = model1
  val capacity : Int = capacity1

  @OneToMany(mappedBy = "airplane")
  val flights : util.List[Flight] = new util.ArrayList[Flight]()
}
