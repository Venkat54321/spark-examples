package files

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{avg, col, count}

object ReadFileAndGenerateCSV1 extends App {

  val sparkSession = SparkSession.builder().master("local[1]").appName("example2").getOrCreate()

  val ratingData = readData("movies-files/ratings.dat", "::")

  val data = ratingData.groupBy(col("_c1").as("MovieId"))
    .agg(count("_c0").as("NumberOfUser"), avg("_c2").as("AverageRating"))

  data.coalesce(1)
    .write
    .format("com.databricks.spark.csv")
    .option("delimiter", "::")
    .mode("overwrite")
    .save("newFile.csv")

  def readData(fileName: String, delimiter: String) = {
    sparkSession.read.option("delimiter", delimiter).csv(fileName)
  }
}

