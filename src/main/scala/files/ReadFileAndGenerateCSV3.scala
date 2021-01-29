package files

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{avg, col, desc}

//https://www.learntospark.com/2020/11/spark-interview-question-coding-round.html

object ReadFileAndGenerateCSV3 extends App{

  val spark = SparkSession.builder()
            .appName("ReadFileApp")
            .master("local[1]").getOrCreate()

  val ratingData = getRatingData("movies-files/ratings.dat","::")
  val movieData = getMoviesData("movies-files/movies.dat","::")

  val finalData = ratingData.join(movieData,ratingData.col("movieId") === movieData.col("Id"),"inner")
  finalData.select("movieId","name","averageRating")
    .sort(desc("averageRating"))
    .limit(100)
    .coalesce(1)
    .write
    .format("com.databricks.spark.csv")
    .option("delimiter","::")
    .option("headers","true")
    .mode("overwrite")
    .save("newFile.csv")


  def getRatingData(fileName:String,delimiter:String) ={
    val ratingData = spark.read.option("delimiter",delimiter).csv(fileName)
    ratingData.groupBy(col("_c1").as("movieId"))
      .agg(avg("_c2").as("averageRating"))
  }

  def getMoviesData(fileName:String,delimiter:String)={
    val rawMovieData = spark.read.option("delimiter",delimiter).csv(fileName)
    rawMovieData.withColumn("Id",col("_c0")).withColumn("name",col("_c1")).withColumn("generes",col("_c2"))
  }
}
