package ru.altsora.SimpleKafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import ru.altsora.SimpleKafka.model.UserDto;

@EnableKafka
@SpringBootApplication
public class SimpleKafkaApplication {

	@KafkaListener(topics="msg")
	public void msgListener(ConsumerRecord<Long, UserDto> record){
		System.out.println("record.topic() = " + record.topic());
		System.out.println("record.partition() = " + record.partition());
		System.out.println("record.key() = " + record.key());
		System.out.println("record.value() = " + record.value());
	}

//	@KafkaListener(topics="msg")
//	public void msgListener(String msg){
//		System.out.println("msg = " + msg);
//	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleKafkaApplication.class, args);
	}

}
