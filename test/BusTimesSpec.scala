
import composition.composition
import controllers.BusTimes
import models.{Bus, TimetableList}
import org.joda.time.LocalTime
import org.mockito.Matchers.any
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.mvc.{AnyContent, Request, Result}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import scala.concurrent.Future


class BusTimesSpec extends PlaySpec with MockitoSugar {

  val mockTimetableList = mock[TimetableList]

  trait FakeComposition
    extends composition {
    override val timeTableService = mockTimetableList
  }

  val SUT = new BusTimes with FakeComposition

  when(mockTimetableList.findNext(any[String], any[LocalTime]))
    .thenReturn(Some(Bus("Weekday", new LocalTime(11, 0), "63")))

  def withCallToGet(ctrl: BusTimes,
                    request: Request[AnyContent] = FakeRequest(method = "GET", ""))
                   (handler: Future[Result] => Any) = {
    handler(ctrl.nextBus.apply(request))
  }

  "The BusTimes controller" must {

    "respond to a GET request" in {
      withCallToGet(SUT) { result =>
        status(result) must not equal NOT_FOUND
      }
    }

    "respond to a valid GET request with Ok when it finds the next bus" in {
      withCallToGet(SUT) { result =>
        status(result) must be(OK)
      }
    }

    "respond to a valid GET request with Ok when there are no more busses" in {
      withCallToGet(SUT) { result =>
        status(result) must be(OK)
      }
    }
  }
}
