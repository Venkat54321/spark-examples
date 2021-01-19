package joins

import joins.SimpleSparkExample.spark
import org.apache.spark.sql.{Dataset, SparkSession}

object DataForJoins extends App{

  val spark = SparkSession.builder().master("local[1]").appName("JoinsExamples").getOrCreate()

  val emp = Seq((1,"Smith",-1,"2018","10","M",3000),
    (2,"Rose",1,"2010","20","M",4000),
    (3,"Williams",1,"2010","10","M",1000),
    (4,"Jones",2,"2005","10","F",2000),
    (5,"Brown",2,"2010","40","",-1),
    (6,"Brown",2,"2010","50","",-1)
  )
  val empColumns = Seq("emp_id","name","superior_emp_id","year_joined",
    "emp_dept_id","gender","salary")
  import spark.sqlContext.implicits._
  case class Employee(name:String,city:String,managerId:Int)
  case class Manager(managerId:Int,name:String,city:String)
  val empCol = Seq("name","city","managerId")
  val managerCol = Seq("managerId","name","city")
  val empData = Seq(Employee("venkat","Bng",10),Employee("Alekhya","Hyd",20))
  val managerData = Seq(Manager(10,"rakesh","hyd"),Manager(20,"rajesh","hyd"))




}
