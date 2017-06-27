package common

import com.typesafe.config.ConfigFactory


trait InitConfs {

  val confs = ConfigFactory.load()

  val influxConfs = confs.getConfig("influx")
  val influxHost = influxConfs.getString("host")
  val influxPort = influxConfs.getInt("port")
  val influxDataBaseName = influxConfs.getString("database")

  val kafkaConfs = confs.getConfig("kafka")
  val kafkaHost = kafkaConfs.getString("host")
  val kafkaPort = kafkaConfs.getInt("port")
}
