package com.project.chatserver.controller;


import com.project.chatserver.controller.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class ChatController {
    @Autowired
    private SimpMessagingTemplate simpleMessagingTemplate;

    @MessageMapping("/message")
    public Message receivePublicMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message){
        simpleMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message); //user/Sole/private
        return message;
    }
}
