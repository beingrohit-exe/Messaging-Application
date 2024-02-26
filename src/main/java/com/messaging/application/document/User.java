package com.messaging.application.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.messaging.application.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.document
 * Created_on - 26 February-2024
 * Created_at - 12 : 15
 */

@Document(indexName = "message-user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties
public class User {

    @Id
    private String userId;
    private String fullName;
    private Status status;
}
