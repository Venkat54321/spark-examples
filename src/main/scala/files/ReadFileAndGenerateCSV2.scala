package files

import files.ReadFileAndGenerateCSV1.{readData, sparkSession}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{asc, col, count, desc, split}

object ReadFileAndGenerateCSV2 extends App{

  val sparkSession = SparkSession.builder().master("local[1]").appName("example2").getOrCreate()

  val movieData = readData("movies-files/movies.dat", "|")

 val moviesAndGenres =  movieData.select(split(col("_c0"),"::").as("data"))
    .select(col("data").getItem(0).as("movieId"),
           col("data").getItem(1).as("movieName"),
          col("data").getItem(2).as("Genres"))

   val finalData = moviesAndGenres.groupBy(col("Genres")).agg(count("movieId").as("NumberOfMovies")).sort(asc("Genres"))

   finalData.coalesce(5)
           .write
           .format("com.databricks.spark.csv")
           .option("delimiter","::")
           .mode("overwrite")
           .save("newFile.csv")

  def readData(fileName: String, delimiter: String) = {
    sparkSession.read.option("delimiter", delimiter).csv(fileName)
  }



}
