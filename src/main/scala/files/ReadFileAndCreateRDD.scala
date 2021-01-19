package files

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, substring_index}

object ReadFileAndCreateRDD extends App{

  val spark = SparkSession.builder()
            .appName("ReadFileApp")
            .master("local[1]").getOrCreate()

  val moviesFile = spark.read.option("delimiter","::").csv("movies.dat")
  val movieName = moviesFile.col("_c1")
  val movieGenres = moviesFile.col("_c2")
  val joinMovieWithGenres = movieName.+(movieGenres)
  println(joinMovieWithGenres)
}
