package ru.altsora.SimpleKafka.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.altsora.SimpleKafka.model.MessageDto;

@RestController
@RequiredArgsConstructor
public class TopicController {
    @Autowired
    private KafkaTemplate<String, MessageDto> kafkaTemplate;

//    @PostMapping("all")
//    public void sendAll(String msgId, String message) {
//        ListenableFuture<SendResult<String, MessageDto>> future1 = kafkaTemplate.send(topic1, msgId, new MessageDto(message));
//        future1.addCallback(System.out::println, System.err::println);
//        ListenableFuture<SendResult<String, MessageDto>> future2 = kafkaTemplate.send(topic2, msgId, new MessageDto(message));
//        future2.addCallback(System.out::println, System.err::println);
//        kafkaTemplate.flush();
//    }

    @PostMapping("jokes")
    public void sendJokes(String msgId, String message) {
        sensMsg("jokes", msgId, message);
    }

    @PostMapping("news")
    public void sendNews(String msgId, String message) {
        sensMsg("news", msgId, message);
    }

    @PostMapping("all")
    public void sendAll(String msgId, String message) {
        sendJokes(msgId, message);
        sendNews(msgId, message);
    }

    private void sensMsg(String topic, String msgId, String message) {
        ListenableFuture<SendResult<String, MessageDto>> send = kafkaTemplate.send(topic, msgId, new MessageDto(message));
        send.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }

}
