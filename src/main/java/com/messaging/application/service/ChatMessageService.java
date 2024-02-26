package com.messaging.application.service;

import com.messaging.application.document.ChatMessage;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.service
 * Created_on - 26 February-2024
 * Created_at - 12 : 31
 */

public interface ChatMessageService {

    ChatMessage save(ChatMessage chatMessage);
    List<ChatMessage> findChatMessages(String senderId, String recipientId);
}
