//  package io.stockgeeks.kafka.stock.ticker.producer.avro;
  package tcb.poc.confluent.kafka.account.producer.avro;

import io.stockgeeks.stock.tick.avro.StockTick;
import lombok.Value;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomAccountGenerator {

  private List<Instrument> instruments;
  private static final String STOCK_EXCHANGE_NASDAQ = "CHECKING";
  private static final String STOCK_EXCHANGE_AMSTERDAM = "SAVINGS";

  private static final String CURRENCY_EURO = "USD";
  private static final String CURRENCY_US_DOLLAR = "USD";

  public RandomAccountGenerator() {
    instruments = Arrays.asList(new Instrument("BOB", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
      new Instrument("ERIC", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
      new Instrument("SAM", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
      new Instrument("JIM", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
      new Instrument("CLIFF", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_EURO),
      new Instrument("GORDON", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_EURO),
            new Instrument("LILY", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
            new Instrument("EMILY", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
            new Instrument("ROSE", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
            new Instrument("LEO", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_EURO),
            new Instrument("ANISH", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
            new Instrument("PRABHU", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
            new Instrument("TARA", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_US_DOLLAR),
            new Instrument("JEFF", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
            new Instrument("LONDON", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_US_DOLLAR),
            new Instrument("HENNA", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
            new Instrument("LANG", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_US_DOLLAR),
            new Instrument("WONG", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
            new Instrument("SEAN", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_US_DOLLAR),
            new Instrument("SHAWN", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
      new Instrument("SONU", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR));
  }

  StockTick generateRandomStockTick() {
    Instrument randomInstrument = pickRandomInstrument();
    BigDecimal randomPrice = generateRandomPrice();
    return new StockTick(randomInstrument.getSymbol(), randomInstrument.getExchange(), randomPrice.toPlainString(),
                         randomInstrument.getCurrency(), String.valueOf(System.currentTimeMillis()));
  }

  private BigDecimal generateRandomPrice() {
    double leftLimit = 1.000D;
    double rightLimit = 3000.000D;

    BigDecimal randomPrice = BigDecimal.valueOf(new RandomDataGenerator().nextUniform(leftLimit, rightLimit));
    randomPrice = randomPrice.setScale(3, RoundingMode.HALF_UP);
    return randomPrice;
  }

  private Instrument pickRandomInstrument() {
    int randomIndex = new Random().nextInt(instruments.size());
    return instruments.get(randomIndex);
  }

  @Value
  private static class Instrument {
    private String symbol;
    private String exchange;
    private String currency;
  }
}
