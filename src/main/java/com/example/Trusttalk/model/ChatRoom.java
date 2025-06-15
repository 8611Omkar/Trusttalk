package com.example.Trusttalk.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user1Id;
    private String user2Id;

    @Column(nullable = false) // ✅ Important for non-nullability
    private String chatId;

    private String senderId;
    private String recipientId;
}
