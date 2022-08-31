package com.faznifarook.allocation;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "mainTopic", groupId = "groupId")
    public void listener (@Payload Order data) {
        System.out.println("Listener received: " + data);
//        JSONObject order = new JSONObject(data);

    }
}
