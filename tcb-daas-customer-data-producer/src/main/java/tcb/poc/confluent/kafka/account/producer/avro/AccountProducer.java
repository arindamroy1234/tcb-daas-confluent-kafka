//package io.stockgeeks.kafka.stock.ticker.producer.avro;
  package tcb.poc.confluent.kafka.account.producer.avro;

import io.stockgeeks.stock.tick.avro.StockTick;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccountProducer {

  private final KafkaTemplate<String, StockTick> kafkaTemplate;

  public AccountProducer(KafkaTemplate<String, StockTick> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void produce(StockTick stockTick) {
    log.info("Produce account balance: {}, has {} {} in {} account", stockTick.getSymbol(), stockTick.getCurrency(), stockTick.getTradeValue(), stockTick.getExchange());
    kafkaTemplate.send(AccountProducerAvroApplication.TOPIC_NAME, stockTick.getSymbol(), stockTick);
  }
}