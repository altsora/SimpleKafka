package ru.altsora.SimpleKafka.controllers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.altsora.SimpleKafka.model.MessageDto;

@Service
public class ConsumerService {

    @KafkaListener(topics = "jokes")
    public void jokes(ConsumerRecord<String, MessageDto> record) {
        showRecord(record);
    }

    @KafkaListener(topics = "news")
    public void news(ConsumerRecord<String, MessageDto> record) {
        showRecord(record);
    }

    private <K, V> void showRecord(ConsumerRecord<K, V> record) {
        System.out.println("record.topic() = " + record.topic());
        System.out.println("record.partition() = " + record.partition());
        System.out.println("record.key() = " + record.key());
        System.out.println("record.value() = " + record.value());
    }
}
