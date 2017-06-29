import clients.KafkaClient

object Main extends App {

  val kafkaConsumer = new KafkaClient(
    Set("BTCE_TICKER_BTC-USD", "BTCE_TRADE_BTC-USD", "BTCE_ORDERBOOK_BTC-USD") ++
    Set("BTCE_TICKER_BTC_ETH", "BTCE_TRADE_BTC-ETH", "BTCE_ORDERBOOK_ETH-BTC") ++

      Set("POLONIEX_TICKER_BTC-USDT", "POLONIEX_TRADE_BTC-USDT", "POLONIEX_ORDERBOOK_BTC-USDT") ++
      Set("POLONIEX_TICKER_BTC_ETH", "POLONIEX_TRADE_BTC-ETH", "POLONIEX_ORDERBOOK_BTC-ETH") ++
      Set("POLONIEX_TICKER_BTC_XMR", "POLONIEX_TRADE_BTC-XMR", "POLONIEX_ORDERBOOK_BTC-XMR"))


  kafkaConsumer.pool
}
