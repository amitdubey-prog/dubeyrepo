package com.edureka.kafkaclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaClient1Application {

	@KafkaListener(topics = "mytopic2", groupId = "a")
	public void consume(String message) {
		System.out.println("*****");
		System.out.println("message received: " + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaClient1Application.class, args);
	}

}
