package ru.altsora.SimpleKafka.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class MessageDto {
    private String text;
    private String datetime;

    public MessageDto(String text) {
        this.text = text;
        this.datetime = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yy").format(LocalDateTime.now());
    }
}
