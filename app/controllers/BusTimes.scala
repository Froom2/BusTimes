package controllers

import org.joda.time.LocalTime
import play.api._
import play.api.mvc._

class BusTimes extends Controller {

  def hello = {
    "hello"
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def time = {
    val temp = new LocalTime(12,0)
    temp
  }

  def nextBus = {
    models.Times.next
  }

}

object BusTimes extends BusTimes