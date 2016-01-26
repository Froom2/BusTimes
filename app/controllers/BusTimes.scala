
package controllers

import org.joda.time.format.DateTimeFormat
import org.joda.time.{LocalDateTime, DateTime}
import play.api._
import play.api.mvc._

class BusTimes extends Controller {


  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def time(busTime: LocalDateTime) = {

    val giveTime = busTime.toString
    giveTime

  }

  def nextBus(currentTime: LocalDateTime) = {


  }

}



object BusTimes extends BusTimes
