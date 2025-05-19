package com.example.Trusttalk.Controller;


import com.example.Trusttalk.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private MessageProducer kafkaProducer;

    // This method is called when a message is received from frontend via WebSocket
    @MessageMapping("/chat")  // Frontend will send message to "/app/chat"
    public void receiveMessage(@Payload String message) {
        System.out.println("Received message from WebSocket: " + message);

        // Send to Kafka
        kafkaProducer.sendMessage(message);
    }
}
