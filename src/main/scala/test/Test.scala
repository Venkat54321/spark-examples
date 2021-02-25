package test

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.dsl.expressions.StringToAttributeConversionHelper
import org.apache.spark.sql.functions.{avg, col, count, first, sum}
import test.Test.fileData

object Test extends App {

  val spark = SparkSession.builder().appName("fileProcessing")
    .master("local[1]").getOrCreate()

  // read
  val fileData = spark.read.option("delimiter"," ").csv("data/*.txt")
  //val fileData = spark.read.textFile("")
  //fileData.show(false)
  fileData.agg(sum("_c0")).show(false)
}