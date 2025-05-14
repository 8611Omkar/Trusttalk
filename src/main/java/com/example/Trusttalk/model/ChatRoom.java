package com.example.Trusttalk.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ChatRoom {

    private long id;
    private String user1Id;
    private String user2Id;
}
