
package controllers

import Composition.{Composition, CompositionImpl}
import models.{Bus, TimetableList}
import org.joda.time.{LocalTime, LocalDateTime}
import play.api.mvc.{AnyContent, Action, Controller}
import views.html.main


class BusTimes extends Controller with CompositionImpl {

  def nextBus: Action[AnyContent] = Action {

    val next: Option[Bus] = timeTableService
      .findNext(LocalDateTime.now.dayOfWeek.getAsText, LocalTime.now) // insert time service here

    next match {
      case Some(bus) => Ok
      case _ => Ok
    }
  }
}


object BusTimes extends BusTimes
