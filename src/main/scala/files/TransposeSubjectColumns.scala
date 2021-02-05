package files

import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.functions.{col, sum}

object TransposeSubjectColumns extends App{
  val sparkSession = SparkSession.builder().appName("TransposeSubjectColumnsApp").master("local[1]").getOrCreate()
  val markData = sparkSession.read.option("delimiter","|").option("header","true").csv("movies-files/marks.dat")
  val data = markData.groupBy(col("ROLL_NO"))
                     .pivot(col("SUBJECT")).agg(functions.max("MARKS"))

  val finalData = data.withColumn("TOTAL",data.col("C") + data.col("M") + data.col("P"))
  finalData.show(false)
}
