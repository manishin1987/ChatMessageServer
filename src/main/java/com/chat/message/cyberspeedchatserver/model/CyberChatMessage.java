package com.chat.message.cyberspeedchatserver.model;

import lombok.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class CyberChatMessage {
    @Id
    private String messageId;
    private String chatId;
    private String recipientId;
    private String senderId;
    private String content;
    private Date timestamp;
}