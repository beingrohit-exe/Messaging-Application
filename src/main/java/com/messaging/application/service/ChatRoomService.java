package com.messaging.application.service;

import java.util.Optional;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.service
 * Created_on - 26 February-2024
 * Created_at - 12 : 37
 */

public interface ChatRoomService {

    Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists);
    String createChatId(String senderId, String recipientId);
}
