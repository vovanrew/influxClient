package clients

import java.util.Properties

import common.InitConfs
import org.apache.kafka.clients.consumer.KafkaConsumer


import scala.collection.JavaConverters._

class KafkaClient(subscriptions: Set[String]) extends InitConfs {

  private val props: Properties = new Properties()
  props.put("bootstrap.servers", kafkaHost + ":" + kafkaPort)
  props.put("group.id", "test")
  props.put("enable.auto.commit", "true")
  props.put("auto.commit.interval.ms", "1000")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "common.serialization.MarketDataDeserializer")

  private val influx: InfluxClient = new InfluxClient

  private val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
  consumer.subscribe(subscriptions.asJava)

  def pool: Unit = {
    while (true) {
      val records = consumer.poll(1000).asScala
      for (record <- records) {
        influx.writeData(
          record.topic.substring(0, record.topic().indexOf("_")),
          record.key(),
          record.topic().substring(record.topic().lastIndexOf("_") + 1, record.topic().size),
          record.value())
      }
    }
  }
}
