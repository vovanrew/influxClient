package clients

import com.paulgoldbaum.influxdbclient.{Database, InfluxDB, Point}
import common.InitConfs
import scala.util.Success
import scala.concurrent.ExecutionContext.Implicits.global


class InfluxClient extends InitConfs {

  private val influxDB: InfluxDB = InfluxDB.connect(host = influxHost, port = influxPort)

  private val database: Database = influxDB.selectDatabase(influxDataBaseName)

  database.exists.onComplete {
    case Success(bool) =>
      bool match {
        case true =>
          Unit
        case false =>
          database.create
      }
  }

  def writeData(table: String, dataType: String, currency: String, data: String): Unit = {
    val point = Point(table)
      .addTag("dataType", dataType)
      .addTag("currency", currency)
      .addField("data", data)

    database.write(point)
  }
}
