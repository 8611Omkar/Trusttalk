
package com.example.Trusttalk.kafka;

import com.example.Trusttalk.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private static final String TOPIC = "chat-messages";

    @Autowired
    private KafkaTemplate<String, ChatMessage> kafkaTemplate;

    public void sendMessage(ChatMessage message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
