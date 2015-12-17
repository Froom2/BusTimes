package models

import java.io.Serializable
import java.util.NoSuchElementException

import org.joda.time.{LocalTime, LocalDateTime}

import scala.annotation.tailrec
import scala.util.Try

case class Timetable (weekday: String, timetableTime: LocalTime, timetableBus: String)  // make this so it takes day of week, time, busNumber

object Timetable {

//  def makeTimes(currentTime: LocalDateTime, day: Int, hour: Int, minutes: Int): LocalDateTime = {
//    // get the year and month from the current time and add it to the hour and minutes
//  }

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






  def findNextNoTry(today: String, currentTime: LocalTime) = {

    timeList.filter(x => x.weekday == today && (x.timetableTime isAfter currentTime))
      match {
        case x::_ => x
        case _ => "No more busses!"
      }
  }





  val timeListNoOrder = List (
    Timetable("Saturday", new LocalTime(10, 0), "63"),
    Timetable("Weekday", new LocalTime(11, 0), "63"),
    Timetable("Weekday", new LocalTime(13, 0), "63"),
    Timetable("Weekday", new LocalTime(12, 0), "62"),
    Timetable("Saturday", new LocalTime(15, 0), "62")
  )

  def findNextRecursive(today: String, currentTime: LocalTime) = {

    val dayList: List[Timetable] = timeList.filter(x => x.weekday == today)
    @tailrec
    def nextFinder(dayList: List[Timetable], timeMore: LocalTime): Timetable = {
      dayList match {
        case x :: tail => if(x.timetableTime.isBefore(timeMore)) {
          nextFinder(tail, x.timetableTime)
        } else x
      }
    }
  }

}
