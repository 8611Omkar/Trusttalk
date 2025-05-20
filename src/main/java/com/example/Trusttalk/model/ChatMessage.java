package com.example.Trusttalk.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ChatMessage {

    private long id;
    private String roomId;
    private String senderId;
    private String receiverId;
   // private List<String> message = new ArrayList<>();
    private  String message;
    private String timestamp;

    public String getContent() {
        return "reach the limit of message" ;
    }

    public String getSender() {
        return null ;

    }
}
