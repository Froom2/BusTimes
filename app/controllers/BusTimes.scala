
package controllers

import models.{Bus, TimetableList}
import org.joda.time.format.DateTimeFormat
import org.joda.time.{LocalTime, LocalDateTime, DateTime}
import play.api._
import play.api.mvc._
import views.html.main

class BusTimes extends Controller {


  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def time(busTime: LocalDateTime) = {

    val giveTime = busTime.toString
    giveTime

  }

  def nextBus(currentTime: LocalDateTime) = {
    val next: Either[String, Bus] = TimetableList.findNext(LocalDateTime.now.dayOfWeek.getAsText, LocalTime.now)

    next match {
      case Right(bus) => Ok(main(bus))
      case _ => InternalServerError
    }
  }

}



object BusTimes extends BusTimes
