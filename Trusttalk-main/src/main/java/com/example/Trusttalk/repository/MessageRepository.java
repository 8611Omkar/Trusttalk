package com.example.Trusttalk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Trusttalk.model.Message;

public interface MessageRepository  extends MongoRepository<Message, Long> {
  
    List<Message> findBySenderId(String senderId);
    List<Message> findByReceiverId(String receiverId);
    List<Message> findBySenderIdAndReceiverId(String senderId, String receiverId);
    boolean existsById(String senderId);   
    
}

