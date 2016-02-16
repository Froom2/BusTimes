package models

import org.joda.time.{LocalDateTime, LocalTime}

case class Bus (weekday: String, timetableTime: LocalTime, timetableBus: String)
