package com.chat.message.cyberspeedchatserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notifications {
    private String notificationId;
    private String senderId;
    private String recipientId;
    private String content;
}