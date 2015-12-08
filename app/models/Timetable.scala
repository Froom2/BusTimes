package models

import org.joda.time.LocalDateTime

case class Timetable (timetableTime: LocalDateTime, timetableBus: String)

object Timetable {

  var timeList = Set (
    Timetable(new LocalDateTime(2015, 12, 8, 12, 0), "62"),
    Timetable(new LocalDateTime(2015, 12, 8, 13, 0), "63")
  )

  def findNext(currentTime: LocalDateTime): Timetable = {
    // could do an iterator to compare current time to the time in the set item, whenever it's closer replace the thing.

    Timetable(new LocalDateTime(2015, 12, 8, 12, 0), "62")
  }

}
