
package controllers

import org.joda.time.format.DateTimeFormat
import org.joda.time.{LocalDateTime, DateTime}
import play.api._
import play.api.mvc._

class BusTimes extends Controller {

  def hello = {
    "hello"
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def time(busTime: LocalDateTime) = {

    val giveTime = busTime.toString
    giveTime

  }

  def nextBus(currentTime: LocalDateTime) = {

    if (currentTime.isBefore(models.Times.next)) {
      val timeOfBus = models.Times.next.toString("EEE dd MMM, yyyy, HH:mm")

      timeOfBus

    }
    else "No more busses!"
  }
}

object BusTimes extends BusTimes
