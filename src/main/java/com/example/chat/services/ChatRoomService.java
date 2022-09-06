package com.example.chat.services;

import com.example.chat.repositories.ChatRoomRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@NoArgsConstructor
@Transactional
public class ChatRoomService {

    private ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }
//    public Optional<Long> getChatId(
//            Long senderId, Long recipientId, boolean createIfNotExist) {
//
//        return chatRoomRepository
//                .findBySenderIdAndRecipientId(senderId, recipientId)
//                .map(ChatRoom::getChatId)
//                .or(() -> {
//                    if(!createIfNotExist) {
//                        return  Optional.empty();
//                    }
//                     var chatId = String.format("%s_%s", senderId, recipientId);
//
//                    ChatRoom senderRecipient = ChatRoom
//                            .builder()
//                            .chatId(Long.valueOf(chatId))
//                            .senderId(Long.valueOf(senderId))
//                            .recipientId(Long.valueOf(recipientId))
//                            .build();
//
//                    ChatRoom recipientSender = ChatRoom
//                            .builder()
//                            .chatId(Long.valueOf(chatId))
//                            .senderId(Long.valueOf(recipientId))
//                            .recipientId(Long.valueOf(senderId))
//                            .build();
//                    chatRoomRepository.save(senderRecipient);
//                    chatRoomRepository.save(recipientSender);
//
//                    return Optional.of( chatId);
//                });
//    }

}