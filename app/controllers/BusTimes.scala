
package controllers

import Composition.{Composition, CompositionImpl}
import models.{Bus, TimetableList}
import org.joda.time.{LocalTime, LocalDateTime}
import play.api.mvc.{AnyContent, Action, Controller}
import views.html.page


trait BusTimes extends Controller with Composition {

  def nextBus: Action[AnyContent] = Action {
    val next: Either[String, Bus] = timeTableService
      .findNext(LocalDateTime.now.dayOfWeek.getAsText, LocalTime.now)

    next match {
      case Right(bus) => Ok(page(bus))
      case _ => InternalServerError
    }
  }
}


object BusTimes extends BusTimes with CompositionImpl
