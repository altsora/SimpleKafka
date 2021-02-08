package ru.altsora.SimpleKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class SimpleKafkaApplication {

	@KafkaListener(topics="msg")
	public void msgListener(String msg){
		System.out.println("msg = " + msg);
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleKafkaApplication.class, args);
	}

}
