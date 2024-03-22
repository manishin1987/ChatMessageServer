package com.chat.message.cyberspeedchatserver.repository;

import com.chat.message.cyberspeedchatserver.model.CyberChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<CyberChatMessage, String> {
    List<CyberChatMessage> findByChatId(String chatId);
}
