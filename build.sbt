name := "spark-examples"
version := "0.1"
scalaVersion := "2.12.11"
lazy val reactiveMongoVersion = "1.0.0-rc.2"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.0.0" % "provided",
  "org.apache.spark" %% "spark-sql" % "3.0.0",
  "org.reactivemongo" %% "reactivemongo" % reactiveMongoVersion,
  "org.reactivemongo" %% "reactivemongo-bson" % "0.20.12",
  // https://mvnrepository.com/artifact/org.apache.spark/spark-streaming
  "org.apache.spark" %% "spark-streaming" % "3.0.0"
)