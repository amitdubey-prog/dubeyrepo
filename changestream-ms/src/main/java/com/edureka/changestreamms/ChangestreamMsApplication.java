package com.edureka.changestreamms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ChangestreamMsApplication {

	@KafkaListener(topics = "paymentdb.payment", groupId = "a")
	public void consume(String message) throws JsonProcessingException {
		System.out.println("*****");
		System.out.println("message received: " + message);
		System.out.println("End");
	}

	public static void main(String[] args) {
		SpringApplication.run(ChangestreamMsApplication.class, args);
	}

}
