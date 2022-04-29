//package io.stockgeeks.kafka.stock.ticker.producer.avro;
  package tcb.poc.confluent.kafka.account.producer.avro;

import io.stockgeeks.stock.tick.avro.StockTick;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RandomAccountProducer {

  private final AccountProducer accountProducer;
  private final RandomAccountGenerator randomAccountGenerator;

  public RandomAccountProducer(AccountProducer accountProducer, RandomAccountGenerator randomAccountGenerator) {
    this.accountProducer = accountProducer;
    this.randomAccountGenerator = randomAccountGenerator;
  }

  @Scheduled(fixedRateString = "${stockTick.producer.rateInMs}")
  public void produceRandomStockTick() {
    StockTick stockTick = randomAccountGenerator.generateRandomStockTick();
    accountProducer.produce(stockTick);
  }
}
