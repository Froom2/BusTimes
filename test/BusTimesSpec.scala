
import controllers.BusTimes
import models.Timetable
import org.joda.time.{LocalDateTime, DateTime, LocalTime}
import org.scalatestplus.play.PlaySpec

class BusTimesSpec extends PlaySpec {

  "The BusTimes controller" must {
    "say hello" in {
      BusTimes.hello must be ("hello")
    }


    "return the time of a bus at a specific time" in {
      BusTimes.time(new LocalDateTime(2015,2,13,1,14)) must be(
        "2015-02-13T01:14:00.000")
    }

    "return the time of the bus if the given time is before the bus time" in {
      BusTimes.nextBus(new LocalDateTime(2015,2,13,1,12)) must be(
        "Fri 13 Feb, 2015, 01:14")
    }

    "return an error message if there are no bus times after the given time" in {
      BusTimes.nextBus(new LocalDateTime(2015,2,13,1,20)) must be(
        "No more busses!")
    }

    "return the time of the next bus when there are two times" in {
      Timetable.findNext(new LocalTime(12, 30)) must be(
        Timetable("Weekday", new LocalTime(13, 0), "63"))
    }

    "return the time of the next bus on weekday" in {

      val currentDay = DateTime.now.toString("EEEEEEEEE")

      println(currentDay)
      Timetable.findNext(new LocalTime(12, 30)) must be(
        Timetable("Weekday", new LocalTime(13, 0), "63"))
    }

  }

}
