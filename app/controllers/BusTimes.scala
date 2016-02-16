
package controllers

import Composition.{Composition, CompositionReal}
import models.{TimeService, Bus, TimetableList}
import org.joda.time.{LocalTime, LocalDateTime}
import play.api.mvc.{AnyContent, Action, Controller}
import views.html.main


class BusTimes extends Controller with CompositionReal {

  def nextBus: Action[AnyContent] = Action {

    val next: Option[Bus] = timeTableService
      .findNext(LocalDateTime.now.dayOfWeek.getAsText, timeService.now)

    next match {
      case Some(bus) => Ok
      case _ => Ok
    }
  }
}


object BusTimes extends BusTimes
