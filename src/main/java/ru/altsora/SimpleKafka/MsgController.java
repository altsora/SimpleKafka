package ru.altsora.SimpleKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;
import ru.altsora.SimpleKafka.model.Address;
import ru.altsora.SimpleKafka.model.UserDto;

@RestController
@RequestMapping("msg")
public class MsgController {

    @Autowired
    private KafkaTemplate<Long, UserDto> kafkaTemplate;

    @PostMapping("/{msgId}")
    public void sendOrder(@PathVariable String msgId, @RequestBody UserDto msg) {
        msg.setAddress(new Address("RUS", "Msk", "Lenina", 1L, 1L));
        ListenableFuture<SendResult<Long, UserDto>> future = kafkaTemplate.send("msg", Long.valueOf(msgId), msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}
