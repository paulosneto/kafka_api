package com.api.consumer.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerApiService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerApiService.class);

    @KafkaListener(topics = "${topic.exemplo-teste-kafka}", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("Consumindo as mensagens da pilha: %s", message));
    }
}
