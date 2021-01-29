package dstream

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}
object DStreamExampleApp extends App{

 // val spark = SparkSession.builder().appName("DStreamApp").master("local[1]").getOrCreate()
  val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
 conf.set("spark.driver.allowMultipleContexts", "true")
  val ssc = new StreamingContext(conf,Seconds(5))

  val lines = ssc.socketTextStream("localhost",9999)
  val words = lines.flatMap(_.split(" "))
  val pairs = words.map(word => (word,1))
  val wordCount = pairs.reduceByKey(_ + _)
  wordCount.print()
  ssc.start()             // Start the computation
  ssc.awaitTermination()
}
