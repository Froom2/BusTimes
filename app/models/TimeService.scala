package models

import org.joda.time.{LocalDateTime, LocalDate, LocalTime}


class TimeService {

  def nowLocalTime: LocalTime = LocalTime.now.withSecondOfMinute(0).withMillisOfSecond(0)

  def nowLocalDate: LocalDate = LocalDate.now

  def dayType(date: LocalDate): String = date.dayOfWeek.getAsText match {
    case "Monday" => "Weekday"
    case "Tuesday" => "Weekday"
    case "Wednesday" => "Weekday"
    case "Thursday" => "Weekday"
    case "Friday" => "Weekday"
    case "Saturday" => "Saturday"
    case "Sunday" => "Sunday"
  }

}
