package com.messaging.application.dao;

import com.messaging.application.document.ChatMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.dao
 * Created_on - 26 February-2024
 * Created_at - 12 : 45
 */

public interface ChatMessageRepository extends ElasticsearchRepository<ChatMessage, String> {
}
