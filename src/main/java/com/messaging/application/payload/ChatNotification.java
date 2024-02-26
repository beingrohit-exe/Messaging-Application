package com.messaging.application.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.payload
 * Created_on - 26 February-2024
 * Created_at - 16 : 28
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatNotification {

    private String id;
    private String senderId;
    private String recipientId;
    private String content;
}
