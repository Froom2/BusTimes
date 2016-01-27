
package models

import org.joda.time.LocalTime


trait TimetableList {

  val timeList = List(
    Bus("Weekday", new LocalTime(11, 0), "63"),
    Bus("Weekday", new LocalTime(12, 0), "62"),
    Bus("Weekday", new LocalTime(13, 0), "63"),
    Bus("Saturday", new LocalTime(10, 0), "63")
  )

  def findNext(today: String, currentTime: LocalTime): Either[String, Bus] = {

    timeList.filter(x => x.weekday == today && (x.timetableTime isAfter currentTime))
    match {
      case x :: _ => Right(x)
      case _ => Left("No more busses!")
    }
  }
}

object TimetableList extends TimetableList
