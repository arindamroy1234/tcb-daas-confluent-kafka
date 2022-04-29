//package io.stockgeeks.kafka.stock.ticker.producer.avro;
	package tcb.poc.confluent.kafka.account.producer.avro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AccountProducerAvroApplication {

	public static final String TOPIC_NAME = "tcb-daas-fiserv-notification-customers";

	public static void main(String[] args) {
		SpringApplication.run(AccountProducerAvroApplication.class, args);
	}

}
