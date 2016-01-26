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

//  def findNextRecursive(today: String, currentTime: LocalTime) = {
//
//    val dayList: List[Timetable] = timeListNoOrder.filter(x => x.weekday == today)
//    @tailrec
//    def nextFinder(list: List[Timetable],
//                   targetTime: LocalTime,
//                   accumulator: LocalTime = new LocalTime(23,59)): Timetable = {
//
//
//      list match {
//        case x :: tail if x.timetableTime.isAfter(targetTime)
//          && x.timetableTime.isBefore(accumulator) => {
//          var accumulator = x.timetableTime
//          nextFinder(tail, targetTime, accumulator)
//        }
//        case x :: Nil  if accumulator.isBefore(new LocalTime(23,59))=> x
//        case _ => Timetable("Error", new LocalTime(0,0), "00")
//      }
//    }
//
//    val result = nextFinder(dayList, currentTime)
//    if (result == Timetable("Error", new LocalTime(0,0), "00")) {"No more busses!"}
//  }

}
