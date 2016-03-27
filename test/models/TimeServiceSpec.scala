package models

import org.joda.time.{LocalDate, LocalTime}
import org.scalatest.{FlatSpec, Matchers}

class TimeServiceSpec extends FlatSpec with Matchers {

  val SUT = new TimeService

  "TimeService" must "return the current time" in {
    val now: LocalTime = SUT.nowLocalTime
    now shouldBe LocalTime.now.withSecondOfMinute(0).withMillisOfSecond(0)
  }

  it must "return the day type when given a LocalDate which is a weekday" in {
    SUT.dayType(new LocalDate(2015, 2, 16)) shouldBe "Weekday"
  }

  it must "return the day type when given a LocalDate which is a Saturday" in {
    val day = SUT.dayType(new LocalDate(2016, 2, 13))
    day shouldBe "Saturday"
  }

}