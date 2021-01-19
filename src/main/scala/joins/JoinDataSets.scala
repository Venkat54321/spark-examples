package joins

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{Dataset, SparkSession}

object JoinDataSets extends App{

  val spark = SparkSession.builder().master("local[1]").appName("JoinsExamples").getOrCreate()

  case class Employee(name:String,city:String,managerId:Int)
  case class Manager(managerId:Int,name:String,city:String)
  val empCol = Seq("name","city","managerId")
  val managerCol = Seq("managerId","name","city")
  val empData = Seq(Employee("venkat","Bng",10),Employee("Alekhya","Hyd",20),Employee("Alekhya","Hyd",30))
  val managerData = Seq(Manager(10,"rakesh","hyd"),Manager(20,"rajesh","hyd"))
  import spark.sqlContext.implicits._
  spark.sparkContext
  val empDataFrame = empData.toDF(empCol: _*)
  val managerDataFrame = managerData.toDF(managerCol: _*)

  val df_emp = empDataFrame.as("dfemp")
  val df_manager = managerDataFrame.as("dfmanager")

  val joinData = df_emp.join(df_manager,df_emp("managerId") === df_manager("managerId"),"inner")

  joinData.show(false)

}
