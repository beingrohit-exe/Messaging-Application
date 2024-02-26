package com.messaging.application.service;

import com.messaging.application.document.User;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.service
 * Created_on - 26 February-2024
 * Created_at - 12 : 29
 */

public interface UserService {

    void saveUser(User user);
    void disconnect(User user);
    List<User> findConnectedUsers();
}
