
package models

import org.joda.time.LocalTime


class TimetableList {

  val timeList = List(
    Bus("Weekday", new LocalTime(11, 0), "63"),
    Bus("Weekday", new LocalTime(12, 0), "62"),
    Bus("Weekday", new LocalTime(13, 0), "63"),
    Bus("Weekday", new LocalTime(23, 59), "63"),
    Bus("Saturday", new LocalTime(10, 0), "63")
  )

  def findNext(today: String, currentTime: LocalTime): Option[Bus] = {

    timeList.filter(x => x.weekday == today && (x.timetableTime isAfter currentTime))
    match {
      case x :: _ => Some(x)
      case _ => None
    }
  }
}
