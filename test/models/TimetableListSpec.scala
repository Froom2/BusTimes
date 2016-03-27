package models

import org.joda.time.LocalTime
import org.scalatest.{FlatSpec, Matchers}


class TimetableListSpec extends FlatSpec with Matchers {

  "findNext" must "return the next bus when there are busses to come" in {
    val SUT = new TimetableList
    SUT.findNext("Weekday", new LocalTime(11, 30)) shouldBe Some(Bus("Weekday", new LocalTime(11, 35), "63"))
  }

}
