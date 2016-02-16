
package controllers

import composition.compositionReal
import models.Bus
import org.joda.time.LocalDateTime
import play.api.mvc.{Action, AnyContent, Controller}
import views.html.main


class BusTimes extends Controller with compositionReal {

  def nextBus: Action[AnyContent] = Action {

    val next: Option[Bus] = timeTableService
      .findNext(timeService.dayType(timeService.nowLocalDate), timeService.nowLocalTime) // need to sort out so it deals with weekdays properly

    next match {
      case Some(bus) => Ok(main(bus))
      case _ => Ok("Moooooo no more busses :(")
    }
  }
}


object BusTimes extends BusTimes
