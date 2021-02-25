package work

object RegexCheck extends App {


  val value = getValueUnit("0n")
  println(value._1)
  println(value._2)


  private def getValueUnit(input: String): (String, String) = {
    if("0".equalsIgnoreCase(input)) {
        ("0","n")
      }else {
      val pattern = "([0-9]+)([A-Za-z]+)".r
      val pattern(value, unit) = input
      (value, unit)
    }
  }

}
