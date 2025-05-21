package com.example.Trusttalk.websocket;

import com.example.Trusttalk.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
class chatwebsocketController {


    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage getContent( ChatMessage chatMessage){
        try
        {

            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        return chatMessage;
    }

}
