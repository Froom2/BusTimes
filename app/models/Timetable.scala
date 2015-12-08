package models

import org.joda.time.{LocalTime, LocalDateTime}

case class Timetable (weekday: String, timetableTime: LocalTime, timetableBus: String)  // make this so it takes day of week, time, busNumber

object Timetable {

//  def makeTimes(currentTime: LocalDateTime, day: Int, hour: Int, minutes: Int): LocalDateTime = {
//    // get the year and month from the current time and add it to the hour and minutes
//  }

  val timeList = Set (
    Timetable("Weekday", new LocalTime(12, 0), "62"),
    Timetable("Weekday", new LocalTime(13, 0), "63")
  )

  def findNext(currentTime: LocalTime): Timetable = {
    val thing: Set[Timetable] = timeList.filter(_.timetableTime isAfter(currentTime))
    thing.head
  }

}
