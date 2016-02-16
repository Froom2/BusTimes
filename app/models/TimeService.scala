package models

import org.joda.time.LocalTime


class TimeService {

  def now: LocalTime = LocalTime.now.withSecondOfMinute(0).withMillisOfSecond(0)
}
