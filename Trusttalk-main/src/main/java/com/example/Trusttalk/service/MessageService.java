package com.example.Trusttalk.service;

import com.example.Trusttalk.model.Message;
import com.example.Trusttalk.repository.MessageRepository;

// import org.apache.el.util.MessageFactory; // Removed unused/incorrect import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(Message messageRequest) {

        // 1. Validate user
        if (!messageRepository.existsById(messageRequest.getSenderId())) {
            throw new IllegalArgumentException("Sender does not exist");
        }

        // 2. Validate content
        String content = messageRequest.getContent();
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be null or empty");
        }

        // 3. Validate all fields
        if (messageRequest.getReceiverId() == null) {
            throw new IllegalArgumentException("Receiver ID cannot be null");
        }
        if (messageRequest.getSenderId() == null) {
            throw new IllegalArgumentException("Sender ID cannot be null");
        }
        if (messageRequest.getTimestamp() == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        if (messageRequest.getStatus() == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        if (messageRequest.getCreatedAt() == null) {
            throw new IllegalArgumentException("CreatedAt cannot be null");
        }

        // 4. Word count limit
        int wordcount = content.trim().split("\\s+").length;
        if (wordcount > 1000) {
            throw new IllegalArgumentException("Message content exceeds 1000 words");
        }

        // 5. You can now process or save this message
        Message message = new Message();
        message.setSenderId(messageRequest.getSenderId());
        message.setReceiverId(messageRequest.getReceiverId());
        message.setContent(messageRequest.getContent());
        message.setTimestamp(messageRequest.getTimestamp());
        message.setIsRead(messageRequest.isRead());
        message.setStatus(messageRequest.getStatus());
        message.setCreatedAt(messageRequest.getCreatedAt());

        // Save the message using the repository
        messageRepository.save(message);

    }
}
