package department

import javax.persistence._

/**
 * Created by prayagupd
 * on 6/25/15.
 */

@MappedSuperclass
abstract class AbstractEntity {
//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  var id : Int = _

  @Version
  var version : Int = _

  //def this() = this()
}
