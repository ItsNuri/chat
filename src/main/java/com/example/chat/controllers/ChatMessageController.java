package com.example.chat.controllers;

import com.example.chat.models.ChatMessage;
import com.example.chat.models.ChatNotification;
import com.example.chat.services.ChatMessageService;
import com.example.chat.services.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatMessageController {

    private SimpMessagingTemplate messagingTemplate;

    private ChatMessageService chatMessageService;

    private ChatRoomService chatRoomService;

    //send chatMessage
//    @MessageMapping("/message")
//    public void sendMessage(@Payload ChatMessage chatMessage) {
//        Optional<Long> chatId = chatRoomService.getChatId(chatMessage.getSenderId(),
//                        chatMessage.getRecipientId(), true);
//
//        chatMessage.setChatId(chatId.get());
//
//        ChatMessage saved = chatMessageService.save(chatMessage);
//        messagingTemplate.convertAndSendToUser(
//                chatMessage.getRecipientName(),"/queue/messages", //????????
//                new ChatNotification(
//                        saved.getId(),
//                        saved.getSenderId(),
//                        saved.getSenderName()));
//    }

    //count new messages
    @GetMapping("/messages/{senderId}/{recipientId}/count")
    public ResponseEntity<Long> countNewMessages(
            @PathVariable Long senderId,
            @PathVariable Long recipientId) {

        return ResponseEntity
                .ok(chatMessageService.countNewMessages(senderId, recipientId));
    }

    //count chats
    // ???????????????????????????????
    @GetMapping()
    public Long countChats() {
        return null;
    }


    //find chat messages
    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<?> findChatMessages (@PathVariable Long senderId,
                                               @PathVariable Long recipientId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId));
    }


    //find message
    @GetMapping("/messages/{id}")
    public ResponseEntity<?> findMessage (@PathVariable Long id) {
        return ResponseEntity
                .ok(chatMessageService.findById(id));
    }
}
