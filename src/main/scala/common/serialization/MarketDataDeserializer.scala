package common.serialization

import java.util

import org.apache.kafka.common.serialization.Deserializer


class MarketDataDeserializer extends Deserializer[String]{

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

  override def deserialize(topic: String, data: Array[Byte]): String = new String(data, "UTF8")

}
