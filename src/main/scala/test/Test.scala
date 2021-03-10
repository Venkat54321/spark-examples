package test

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, count, sum}


object Test extends App {

  val spark = SparkSession.builder().appName("fileProcessing")
    .master("local[1]").getOrCreate()

  import spark.implicits._
  val fileData = spark.read.option("delimiter"," ").csv("data/*.txt")
  //val fileData = spark.read.textFile("")
  //fileData.show(false)
 // val colSel = "_c4"
 // fileData.select(colSel).show(false)
  val list = Seq("").toDS()
  val cals = fileData.columns
  val finalDataSet =  cals.map{ row =>
     fileData.select(col(row))
      .filter(col(row) =!= "x")
      .agg(sum(row) / count(row)).coalesce(1).write
       .format("com.databricks.spark.csv")
       .option("delimiter","\n")
       .mode("append")
       .save("newFile.csv")
  }

}