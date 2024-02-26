package com.messaging.application.implementation;

import com.messaging.application.dao.ChatMessageRepository;
import com.messaging.application.document.ChatMessage;
import com.messaging.application.service.ChatMessageService;
import com.messaging.application.service.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.implementation
 * Created_on - 26 February-2024
 * Created_at - 16 : 17
 */

@Service
public class ChatMessageServiceImplementation implements ChatMessageService {

    private final ChatRoomService chatRoomService;
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageServiceImplementation(
            ChatRoomService chatRoomService,
            ChatMessageRepository chatMessageRepository) {
        this.chatRoomService = chatRoomService;
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow();
        chatMessage.setChatId(chatId);
        return chatMessageRepository.save(chatMessage);
    }

    @Override
    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        Optional<String> chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }
}
