package com.messaging.application.controller;

import com.messaging.application.document.User;
import com.messaging.application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.controller
 * Created_on - 26 February-2024
 * Created_at - 12 : 56
 */

@Controller
public class UserController {

    private final UserService userService;

    public UserController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(
            @Payload User user
    ) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public User disconnectUser(
            @Payload User user
    ) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
