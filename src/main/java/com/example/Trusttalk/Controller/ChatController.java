package com.example.Trusttalk.Controller;

import com.example.Trusttalk.model.ChatMessage;
import com.example.Trusttalk.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody ChatMessage message) {

        // Step 1: Validate message
        boolean isValid = chatService.validateMessage(message);
        if (!isValid) {
            return ResponseEntity
                    .badRequest()
                    .body(" for ti yiu  ");
        }
//Invalid message: Null, empty, or too long.
        // Step 2: Process and return response
        ChatMessage processed = chatService.processMessage(message);
        return ResponseEntity.ok(processed);
    }
}
