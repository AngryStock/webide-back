package king.ide.controller;

import king.ide.domain.ChatMessage;
import king.ide.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messageSendingOperations;
    private final ChatService chatService;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        log.info("message type = {}, message = {}", message.getType(),message.getMessage());
        if(ChatMessage.MessageType.ENTER.equals(message.getType())){
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }

        chatService.save(message);

        messageSendingOperations.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @GetMapping("/chat/roomId/{roomId}")
    @ResponseBody
    public List<ChatMessage> findMessageByRoomId(@PathVariable String roomId){
        return chatService.findByRoomId(roomId);
    }

    @GetMapping("/chat/id/{id}")
    @ResponseBody
    public ChatMessage findMessageById(@PathVariable Long id) {
        return chatService.findById(id);
    }

    @GetMapping("/chat/sender/{sender}")
    @ResponseBody
    public List<ChatMessage> findMessageBySender(@PathVariable String sender) {
        return chatService.findBySender(sender);
    }
}
