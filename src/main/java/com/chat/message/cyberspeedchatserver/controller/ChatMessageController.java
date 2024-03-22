package com.chat.message.cyberspeedchatserver.controller;

import com.chat.message.cyberspeedchatserver.model.CyberChatMessage;
import com.chat.message.cyberspeedchatserver.model.Notifications;
import com.chat.message.cyberspeedchatserver.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    @MessageMapping("/chat")
    public void sendMessage(@Payload CyberChatMessage chatMessage) {
        CyberChatMessage savedMsg = chatService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/queue/messages",
                new Notifications(
                        savedMsg.getMessageId(),
                        savedMsg.getSenderId(),
                        savedMsg.getRecipientId(),
                        savedMsg.getContent()
                )
        );
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<CyberChatMessage>> findChatMessages(@PathVariable String senderId,
                                                                   @PathVariable String recipientId) {
        return ResponseEntity
                .ok(chatService.findChatMessages(senderId, recipientId));
    }

    @MessageMapping("/chat/addUser")
    public CyberChatMessage addUser(
            @Payload CyberChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add new user in the session
        headerAccessor.getSessionAttributes().put("sender", chatMessage.getSenderId());
        return chatMessage;
    }

}
