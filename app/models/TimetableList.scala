
package models

import org.joda.time.LocalTime


class TimetableList {

  val timeList = List(
    Bus("Weekday", new LocalTime(6, 34), "63"),
    Bus("Weekday", new LocalTime(6, 54), "63"),
    Bus("Weekday", new LocalTime(7, 14), "63"),
    Bus("Weekday", new LocalTime(7, 33), "63"),
    Bus("Weekday", new LocalTime(7, 53), "63"),
    Bus("Weekday", new LocalTime(8, 13), "63"),
    Bus("Weekday", new LocalTime(8, 33), "63"),
    Bus("Weekday", new LocalTime(8, 50), "63"),
    Bus("Weekday", new LocalTime(9, 5), "63"),
    Bus("Weekday", new LocalTime(9, 20), "63"),
    Bus("Weekday", new LocalTime(9, 35), "63"),
    Bus("Weekday", new LocalTime(9, 50), "63"),

    Bus("Weekday", new LocalTime(10, 5), "63"),
    Bus("Weekday", new LocalTime(10, 20), "63"),
    Bus("Weekday", new LocalTime(10, 35), "63"),
    Bus("Weekday", new LocalTime(10, 50), "63"),

    Bus("Weekday", new LocalTime(11, 5), "63"),
    Bus("Weekday", new LocalTime(11, 20), "63"),
    Bus("Weekday", new LocalTime(11, 35), "63"),
    Bus("Weekday", new LocalTime(11, 50), "63"),

    Bus("Weekday", new LocalTime(12, 5), "63"),
    Bus("Weekday", new LocalTime(12, 20), "63"),
    Bus("Weekday", new LocalTime(12, 35), "63"),
    Bus("Weekday", new LocalTime(12, 50), "63"),

    Bus("Weekday", new LocalTime(13, 5), "63"),
    Bus("Weekday", new LocalTime(13, 20), "63"),
    Bus("Weekday", new LocalTime(13, 35), "63"),
    Bus("Weekday", new LocalTime(13, 50), "63"),

    Bus("Weekday", new LocalTime(14, 5), "63"),
    Bus("Weekday", new LocalTime(14, 20), "63"),
    Bus("Weekday", new LocalTime(14, 35), "63"),
    Bus("Weekday", new LocalTime(14, 50), "63"),

    Bus("Weekday", new LocalTime(15, 5), "63"),
    Bus("Weekday", new LocalTime(15, 20), "63"),
    Bus("Weekday", new LocalTime(15, 35), "63"),
    Bus("Weekday", new LocalTime(15, 50), "63"),

    Bus("Weekday", new LocalTime(16, 5), "63"),
    Bus("Weekday", new LocalTime(16, 20), "63"),
    Bus("Weekday", new LocalTime(16, 35), "63"),
    Bus("Weekday", new LocalTime(16, 55), "63"),


    Bus("Weekday", new LocalTime(17, 15), "63"),
    Bus("Weekday", new LocalTime(17, 32), "63"),
    Bus("Weekday", new LocalTime(17, 47), "63"),
    Bus("Weekday", new LocalTime(18, 2), "63"),
    Bus("Weekday", new LocalTime(18, 19), "63"),
    Bus("Weekday", new LocalTime(18, 42), "63"),
    Bus("Weekday", new LocalTime(19, 12), "63"),
    Bus("Weekday", new LocalTime(19, 42), "63"),

    Bus("Weekday", new LocalTime(20, 12), "63"),
    Bus("Weekday", new LocalTime(20, 42), "63"),

    Bus("Weekday", new LocalTime(21, 12), "63"),
    Bus("Weekday", new LocalTime(21, 42), "63"),

    Bus("Weekday", new LocalTime(22, 12), "63"),
    Bus("Weekday", new LocalTime(22, 42), "63"),
    Bus("Weekday", new LocalTime(23, 11), "63")

  )

  def findNext(today: String, currentTime: LocalTime): Option[Bus] = {

    timeList.filter(x => x.weekday == today && (x.timetableTime isAfter currentTime))
    match {
      case x :: _ => Some(x)
      case _ => None
    }
  }
}
