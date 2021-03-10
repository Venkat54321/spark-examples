package dataset

import org.apache.spark.sql.{DataFrame, SparkSession}

object CreateDataSet extends App{


  val spark = SparkSession.builder().appName("fileProcessing")
    .master("local[1]").getOrCreate()

  case class Person(name:String,salary:Double)
  val data = Seq(Person("venkat",2.2),Person("Alekhya",2.4))
  import spark.implicits._
  val ds= data.toDS()
  ds.show(false)


}
