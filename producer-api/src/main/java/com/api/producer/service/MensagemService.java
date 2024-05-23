package com.api.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    // Usado para "criar um log" de eventos nessa classe de service
    private static final Logger logger = LoggerFactory.getLogger(MensagemService.class);

    // Passa o topico que está armazenado em application.yml através dessa anotação
    @Value("${topic.exemplo-teste-kafka}")
    private String topicExemploTesteKafka;

    // Responsável por enviar a mensagem ao tópico predefinido
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // Método que enviará o objeto passado pela requisicão da pagina de controller para o broker
    public void sendMessage(String message){
        logger.info("Mensagem -> {}", message);
        this.kafkaTemplate.send(topicExemploTesteKafka, message);


    }


}
