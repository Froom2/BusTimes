package composition

import models.{TimeService, TimetableList}


trait composition {

  val timeTableService : TimetableList
  val timeService: TimeService
}

trait compositionReal
  extends composition {

  override val timeTableService = new TimetableList
  override val timeService = new TimeService

}
