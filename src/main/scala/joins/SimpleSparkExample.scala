package joins

import org.apache.spark.sql.SparkSession

object SimpleSparkExample extends App {

  val spark = SparkSession.builder().master("local[1]").appName("JoinsExamples").getOrCreate()

  // people table
  val people = Seq(("venkat", "SE"), ("Alekhya", "VLSI"))
  val col = Seq("name", "job")

  import spark.sqlContext.implicits._

  val peopleDF = people.toDF(col: _*)
  peopleDF.show(false)

  //location table
  val location = Seq(("SE", "Ban"), ("VLSI", "Hyd"))
  val lCol = Seq("job", "location")

  import spark.sqlContext.implicits._

  val locationDF = location.toDF(lCol: _*)
  locationDF.show(false)

  //inner join
  peopleDF.join(locationDF, peopleDF("job") === locationDF("job"), "inner").show(false)


}
