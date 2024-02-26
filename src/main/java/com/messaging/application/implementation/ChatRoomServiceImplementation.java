package com.messaging.application.implementation;

import com.messaging.application.dao.ChatRoomRepository;
import com.messaging.application.document.ChatRoom;
import com.messaging.application.service.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.implementation
 * Created_on - 26 February-2024
 * Created_at - 16 : 13
 */

@Service
public class ChatRoomServiceImplementation implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomServiceImplementation(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists) {
        return chatRoomRepository
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(()-> {
                    if (createNewRoomIfNotExists) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(chatId);
                    }
                    return Optional.empty();
                });
    }

    @Override
    public String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);
        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}
