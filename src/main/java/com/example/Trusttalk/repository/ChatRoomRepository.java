package com.example.Trusttalk.repository;

import com.example.Trusttalk.model.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findByUser1IdAndUser2Id(String user1Id, String user2Id);
}

