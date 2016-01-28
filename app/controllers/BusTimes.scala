
package controllers

import models.{Bus, TimetableList}
import org.joda.time.{LocalTime, LocalDateTime}
import play.api.mvc.Controller
import views.html.page


class BusTimes extends Controller {

  def nextBus = {
    val next: Either[String, Bus] = TimetableList.findNext(LocalDateTime.now.dayOfWeek.getAsText, LocalTime.now)

    next match {
      case Right(bus) => Ok(page(bus))
      case _ => InternalServerError
    }
  }

}


object BusTimes extends BusTimes
