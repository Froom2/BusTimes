import org.joda.time.LocalTime
import org.scalatest.{Matchers, FlatSpec}
import models.TimeService

class TimeServiceSpec extends FlatSpec with Matchers {

  val SUT = new TimeService

  "TimeService" must "return the current time" in {
    SUT.now shouldBe LocalTime.now.withSecondOfMinute(0).withMillisOfSecond(0)
  }
}