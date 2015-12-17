
import controllers.BusTimes
import models.Timetable
import org.joda.time.{LocalDateTime, DateTime, LocalTime}
import org.scalatestplus.play.PlaySpec

class BusTimesSpec extends PlaySpec {

  "The BusTimes controller" must {

    val currentDay = DateTime.now.toString("EEEEEEEEE")
    val testWeekday = "Weekday"
    val testSaturday = "Saturday"

    "return the time of a bus at a specific time" in {
      BusTimes.time(new LocalDateTime(2015,2,13,1,14)) must be ("2015-02-13T01:14:00.000")
    }
    "return the time of the bus if the given time is before the bus time" in {
      BusTimes.nextBus(new LocalDateTime(2015,2,13,1,12)) must be ("Fri 13 Feb, 2015, 01:14")
    }
    "return an error message if there are no bus times after the given time" in {
      BusTimes.nextBus(new LocalDateTime(2015,2,13,1,20)) must be ("No more busses!")
    }

    "use the findNext function to return the time of the next bus when there are multiple times" in {
      Timetable.findNext(testWeekday, new LocalTime(12, 30)) must be (Timetable("Weekday", new LocalTime(13, 0), "63"))
    }
    "use the findNext function to return the time of the next bus on weekday" in {
      Timetable.findNext(testWeekday, new LocalTime(12, 30)) must be (Timetable("Weekday", new LocalTime(13, 0), "63"))
    }
    "use the findNext function to return the time of the next bus on a Saturday" in {
      Timetable.findNext(testSaturday, new LocalTime(9, 30)) must be (Timetable("Saturday", new LocalTime(10, 0), "63"))
    }
    "use the findNext function to return an error if there are no more busses" in {
      Timetable.findNext(testSaturday, new LocalTime(13, 30)) must be("No more busses!")
    }


    "use the findNextNoTry function to return the time of the next bus when there are multiple times" in {
      Timetable.findNextNoTry(testWeekday, new LocalTime(12, 30)) must be (Timetable("Weekday", new LocalTime(13, 0), "63"))
    }
    "use the findNextNoTry function to return the time of the next bus on weekday" in {
      Timetable.findNextNoTry(testWeekday, new LocalTime(12, 30)) must be (Timetable("Weekday", new LocalTime(13, 0), "63"))
    }
    "use the findNextNoTry function to return the time of the next bus on a Saturday" in {
      Timetable.findNextNoTry(testSaturday, new LocalTime(9, 30)) must be (Timetable("Saturday", new LocalTime(10, 0), "63"))
    }
    "use the findNextNoTry function to return an error if there are no more busses" in {
      Timetable.findNextNoTry(testSaturday, new LocalTime(13, 30)) must be("No more busses!")
    }


//    "use the findNextRecursive function to return the time of the next bus when there are multiple times" in {
//      Timetable.findNextRecursive(testWeekday, new LocalTime(12, 30)) must be (Timetable("Weekday", new LocalTime(13, 0), "63"))
//    }
//    "use the findNextRecursive function to return the time of the next bus on weekday" in {
//      Timetable.findNextRecursive(testWeekday, new LocalTime(12, 30)) must be (Timetable("Weekday", new LocalTime(13, 0), "63"))
//    }
//    "use the findNextRecursive function to return the time of the next bus on a Saturday" in {
//      Timetable.findNextRecursive(testSaturday, new LocalTime(9, 30)) must be (Timetable("Saturday", new LocalTime(10, 0), "63"))
//    }
//    "use the findNextRecursive function to return an error if there are no more busses" in {
//      Timetable.findNextRecursive(testSaturday, new LocalTime(13, 30)) must be("No more busses!")
//    }
  }

}
