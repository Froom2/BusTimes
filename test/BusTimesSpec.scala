import controllers.BusTimes
import org.joda.time.LocalTime
import org.scalatestplus.play.PlaySpec

class BusTimesSpec extends PlaySpec {

  "The BusTimes controller" must {
    "say hello" in {
      BusTimes.hello must be ("hello")
    }

    "return the time of a bus" in {
      BusTimes.time must be (new LocalTime(12,0))
    }

    "Get the time of the next bus from a model" in {
      BusTimes.nextBus must be (new LocalTime(1,15))
    }

  }

}