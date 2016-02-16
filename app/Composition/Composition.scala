package Composition

import models.{TimeService, TimetableList}


trait Composition {

  val timeTableService : TimetableList
  val timeService: TimeService
}

trait CompositionReal
  extends Composition {

  override val timeTableService = new TimetableList
  override val timeService = new TimeService

}
