package com.messaging.application.dao;

import com.messaging.application.document.ChatRoom;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.dao
 * Created_on - 26 February-2024
 * Created_at - 12 : 45
 */

public interface ChatRoomRepository extends ElasticsearchRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
