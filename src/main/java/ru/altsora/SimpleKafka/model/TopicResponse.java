package ru.altsora.SimpleKafka.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TopicResponse {
    private List<String> topics;

    public TopicResponse() {
        topics = new ArrayList<>();
        topics.add("Все темы");
    }

    public void addTopic(String topic) {
        topics.add(topic);
    }
}
