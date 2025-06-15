package com.example.Trusttalk.service;

import com.example.Trusttalk.model.ChatRoom;
import com.example.Trusttalk.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class     ChatroomService { // ✅ Class name capitalized as per convention

    private final ChatRoomRepository chatRoomRepository;



    public Optional<String> getChatRoomId(String user1Id, String user2Id, boolean createNewRoomIfNotExists) {
        return chatRoomRepository
                .findByUser1IdAndUser2Id(user1Id, user2Id)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (createNewRoomIfNotExists) {
                        var chatId = createChatId(user1Id, user2Id);
                        return Optional.of(chatId);
                    }
                    return Optional.empty();
                });
    }

    private String createChatId(String user1Id, String user2Id) {
        var chatId = String.format("%s-%s", user1Id, user2Id);
//
//        ChatRoom user1Recipient = ChatRoom.builder()
        ChatRoom chatRoom = ChatRoom.builder()
                .chatId(chatId)
                .senderId(user1Id)
                .recipientId(user2Id)
                .build();
        ChatRoom recipientUser1 = ChatRoom.builder()

                .chatId(chatId)
                .senderId(user2Id)
                .recipientId(user1Id)
                .build();

//        chatRoomRepository.save(user1Recipient);
        chatRoomRepository.save(recipientUser1);

        return chatId;
    }

}
