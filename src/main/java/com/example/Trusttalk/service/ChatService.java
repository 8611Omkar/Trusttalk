package com.example.Trusttalk.service;

import com.example.Trusttalk.model.ChatMessage;
import com.example.Trusttalk.model.User;
import com.example.Trusttalk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatService {

    @Autowired
    private UserRepository userRepository;

    // Save a user entry
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public List<ChatMessage> getMessagesOfUser(String userId) {

        return null; // placeholder
    }

    // Message validation method
    public boolean validateMessage(ChatMessage message) {
        if (message == null) return false;

        if (message.getSender() == null || message.getSender().trim().isEmpty()) {
            return false;
        }

        // Check content is not null or empty
        if (message.getContent() == null || message.getContent().trim().isEmpty()) {
            return false;
        }

        // Check content length max 1000 chars
        return message.getContent().length() <= 1000;
    }

    public ChatMessage processMessage(ChatMessage message) {
        if (!validateMessage(message)) {
            throw new IllegalArgumentException("Invalid message");
        }
        message.setTimestamp(String.valueOf(System.currentTimeMillis()));

        // TODO: Save message in DB via repository or publish on Kafka topic
        // chatMessageRepository.save(message);

        return message;
    }
}
