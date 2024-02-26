package com.messaging.application.dao;

import com.messaging.application.document.User;
import com.messaging.application.enums.Status;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.dao
 * Created_on - 26 February-2024
 * Created_at - 12 : 44
 */

public interface UserRepository extends ElasticsearchRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
