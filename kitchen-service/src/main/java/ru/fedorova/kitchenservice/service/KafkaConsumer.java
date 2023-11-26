package ru.fedorova.kitchenservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "orderState", groupId = "KitchenGroupId")
    public void listen(@Payload String message) {
        System.out.println("New order from pizza service! Order: " + message);
        // Дальнейшая обработка сообщения
    }
}
