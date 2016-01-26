package models

import java.io.Serializable
import java.util.NoSuchElementException

import org.joda.time.{LocalTime, LocalDateTime}

import scala.annotation.tailrec
import scala.util.Try

case class Timetable (weekday: String, timetableTime: LocalTime, timetableBus: String)  // make this so it takes day of week, time, busNumber

object Timetable {

  val timeList = List (
    Timetable("Weekday", new LocalTime(11, 0), "63"),
    Timetable("Weekday", new LocalTime(12, 0), "62"),
    Timetable("Weekday", new LocalTime(13, 0), "63"),
    Timetable("Saturday", new LocalTime(10, 0), "63")
  )

  def findNext(today: String, currentTime: LocalTime): Serializable = {

    val result: Try[Timetable] = Try(timeList.filter(x =>
      x.weekday == today && (x.timetableTime isAfter currentTime))
      .head)
    result.getOrElse("No more busses!")
  }

  def findNextNoTry(today: String, currentTime: LocalTime): Either[String, Timetable] = {

    timeList.filter(x => x.weekday == today && (x.timetableTime isAfter currentTime))
      match {
        case x::_ => Right(x)
        case _ => Left("No more busses!")
      }
  }

}
