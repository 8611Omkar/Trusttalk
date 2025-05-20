package com.example.Trusttalk.Controller;

import com.example.Trusttalk.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ChatController {


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


        return  new ChatMessage();
    }

}
