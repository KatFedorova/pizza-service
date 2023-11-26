package ru.fedorova.orderservice.scheduled;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaScheduledWriter {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${spring.kafka.template.default-topic}")
    private final String defaultTopicName = "orderState";

    @Scheduled(fixedDelay = 100000)
    public void addMessage() {
        for (int i = 1; i < 6; i++) {

            kafkaTemplate.send(defaultTopicName, "Need " + i + " ingredient pizza. Current time is "+ LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            log.info("Need " + i + " ingredient pizza");
        }
    }
}
