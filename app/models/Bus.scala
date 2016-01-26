package models

import java.io.Serializable
import java.util.NoSuchElementException

import org.joda.time.{LocalTime, LocalDateTime}

import scala.annotation.tailrec
import scala.util.Try

//TODO: make this so it takes day of week, time, busNumber
case class Bus (weekday: String, timetableTime: LocalTime, timetableBus: String)


