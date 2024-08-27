package com.TheFirstChatApp.FirstChatApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.TheFirstChatApp.FirstChatApp.models.ChatMessage;


@Controller
public class ChatController {
    
     @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/openChat")
    @SendTo("/topic/openMessage")
    public ChatMessage openChat(ChatMessage message) throws Exception {

        return new ChatMessage(message.getFrom(), message.getTo(), message.getContent());
        
    }

    @MessageMapping("/privateChat")
    public void privateChat(ChatMessage message) {
        messagingTemplate.convertAndSendToUser(message.getTo(), "/queue/privateMessage",
        new ChatMessage(message.getFrom(), message.getTo(), message.getContent()));
       
    }
    
}
