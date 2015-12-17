package models

import org.joda.time.LocalTime

case class Timetable (weekday: String, timetableTime: LocalTime, timetableBus: String)  // make this so it takes day of week, time, busNumber

object Timetable {

  val timeList = Set (
    Timetable("Weekday", new LocalTime(11, 0), "63"),
    Timetable("Weekday", new LocalTime(12, 0), "62"),
    Timetable("Weekday", new LocalTime(13, 0), "63")
  )

  def findNext(currentTime: LocalTime): Timetable = {
    val thing: Set[Timetable] = timeList.filter(_.timetableTime isAfter currentTime)
    thing.head
  }

}
