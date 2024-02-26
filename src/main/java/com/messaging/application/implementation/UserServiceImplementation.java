package com.messaging.application.implementation;

import com.messaging.application.dao.UserRepository;
import com.messaging.application.document.User;
import com.messaging.application.enums.Status;
import com.messaging.application.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Chat Application
 * Package - com.messaging.application.implementation
 * Created_on - 26 February-2024
 * Created_at - 12 : 49
 */

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    @Override
    public void disconnect(User user) {
        User storedUser = userRepository.findById(user.getUserId())
                .orElse(null);
        if (storedUser!=null) {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }
    }

    @Override
    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
