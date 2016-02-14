package Composition

import models.TimetableList


trait Composition {

  val timeTableService : TimetableList
}

trait CompositionImpl
  extends Composition {

  override val timeTableService = new TimetableList
}
