package mongo

import mongo.MongoConnection.{dbFromConnection, write}
import reactivemongo.api.bson.BSONDocument
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.commands.WriteResult
import reactivemongo.api.{AsyncDriver, MongoConnection}
import reactivemongo.bson.BSONDateTime

import java.time.LocalDateTime
import java.util.Date
import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent._
import ExecutionContext.Implicits.global

object MongoConnection extends App {

  val date = BSONDateTime(System.currentTimeMillis())
  val date2 = LocalDateTime.now()

  val document1 = BSONDocument(
    "_id" -> "Venkat1",
    "firstName" -> "Stephane",
    "lastName" -> "Godbillon",
    "time" -> date2,
    "age" -> 29)

 // val url = "mongodb://127.0.0.1:27017/?authSource=admin&readPreference=primary&ssl=false"
 //val url =   "mongodb://colormaster:VV4kdck6pQGYWW@localhost:27017/cloud_vishnu?authSource=admin"
  val url = "mongodb://root:cnapp@localhost:27017/?authSource=admin&readPreference=primary&ssl=false"
  val driver: Future[MongoConnection] = AsyncDriver().connect(url)

  insertToMongo()
 // readFromMongo()

  def readFromMongo(): Unit ={
    driver.onComplete {
      case Success(value) => {
        val collection = dbFromConnection(value)
        collection.onComplete {
          case Success(col) => {
            val res = read(col)
            Thread.sleep(3000)
            res.onComplete {
              case Success(res1) =>
                println(s"Read successfully ${res1.get.values.toString()}")
              case Failure(exception) => println(exception)
            }
          }
          case Failure(exception) => println(exception)
        }
      }
    }
  }

  def insertToMongo(): Unit ={


    driver.onComplete {
      case Success(value) => {
        val collection = dbFromConnection(value)
        collection.onComplete {
          case Success(col) => {
            val res = write(col)
            res.onComplete{
              case Success(value) => println(s"Write successfully $value")
              case Failure(exception) => print(exception)
            }
          }
          case Failure(exception) => println(exception)
        }
      }
    }
  }



  def write(coll: BSONCollection): Future[WriteResult] = {
    val writeRes: Future[WriteResult] = coll.insert.one(document1)
    writeRes
  }

  def dbFromConnection(connection: MongoConnection): Future[BSONCollection] =
    connection.database("test").
      map(_.collection("test"))

  def read(coll: BSONCollection):Future[Option[BSONDocument]]= {
    val doc: BSONDocument = BSONDocument("age" -> 29)
    coll.find(doc).one[BSONDocument]
  }
}
