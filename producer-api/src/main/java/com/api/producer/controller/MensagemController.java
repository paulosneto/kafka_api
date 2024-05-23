package com.api.producer.controller;

import com.api.producer.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    MensagemService mensagemService;

    // Requisição responsável de enviar os dados para o
    // broker armazenar em fila as informações, aguardando serem consumidas
    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody String mensagem){
        mensagemService.sendMessage(mensagem);
        return ResponseEntity.ok().body("Mensagem "+ mensagem +" enviada com sucesso...");
    }
}
