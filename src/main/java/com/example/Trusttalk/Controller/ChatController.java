package com.example.Trusttalk.Controller;

import com.example.Trusttalk.dto.MessageDTO;
import com.example.Trusttalk.model.Message;
import com.example.Trusttalk.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        chatService.saveMessage(messageDTO);
        return ResponseEntity.ok("Message sent");
    }

    @GetMapping("/{senderId}/{receiverId}")
    public ResponseEntity<List<Message>> getChat(
            @PathVariable String senderId,
            @PathVariable String receiverId) {
        return ResponseEntity.ok(chatService.getMessagesBetween(senderId, receiverId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Message>> getUserMessages(@PathVariable String userId) {
        return ResponseEntity.ok(chatService.getMessagesOfUser(userId));
    }

    @PutMapping("/{messageId}")
    public ResponseEntity<String> updateMessage(@PathVariable String messageId, @RequestBody String newContent) {
        chatService.updateMessage(messageId, newContent);
        return ResponseEntity.ok("Message updated");
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<String> deleteMessage(@PathVariable String messageId) {
        chatService.deleteMessageById(messageId);
        return ResponseEntity.ok("Message deleted");
    }
}
