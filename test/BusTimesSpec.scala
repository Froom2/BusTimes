
import controllers.BusTimes
import models.{TimetableList, Bus}
import org.joda.time.{LocalDateTime, DateTime, LocalTime}
import org.scalatestplus.play.PlaySpec

class BusTimesSpec extends PlaySpec {

  "The BusTimes controller" must {

    val currentDay = DateTime.now.toString("EEEEEEEEE")
    val testWeekday = "Weekday"
    val testSaturday = "Saturday"



    "use the findNextNoTry function to return the time of the next bus when there are multiple times" in {
      TimetableList.findNext(testWeekday, new LocalTime(12, 30)) must be (Right(Bus("Weekday", new LocalTime(13, 0), "63")))
    }
    "use the findNextNoTry function to return the time of the next bus on weekday" in {
      TimetableList.findNext(testWeekday, new LocalTime(12, 30)) must be (Right(Bus("Weekday", new LocalTime(13, 0), "63")))
    }
    "use the findNextNoTry function to return the time of the next bus on a Saturday" in {
      TimetableList.findNext(testSaturday, new LocalTime(9, 30)) must be (Right(Bus("Saturday", new LocalTime(10, 0), "63")))
    }
    "use the findNextNoTry function to return an error if there are no more busses" in {
      TimetableList.findNext(testSaturday, new LocalTime(13, 30)) must be(Left("No more busses!"))
    }

  }

}
