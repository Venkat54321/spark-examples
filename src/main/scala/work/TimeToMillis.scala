package work

import java.time.{LocalDateTime, ZoneOffset}
import java.time.format.DateTimeFormatter

object TimeToMillis extends App {


  println(dateTimeStringToEpoch("2021-03-17T03:31:56Z","yyyy-MM-dd'T'HH:mm:ss'Z'"))

  def dateTimeStringToEpoch(s: String, formatter: String): Long =
    LocalDateTime.parse(s, DateTimeFormatter.ofPattern(formatter)).toEpochSecond(ZoneOffset.UTC)

}
