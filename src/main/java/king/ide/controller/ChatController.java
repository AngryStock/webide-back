package king.ide.controller;

import king.ide.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messageSendingOperations;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        log.info("message type = {}, message = {}", message.getType(),message.getMessage());
        if(ChatMessage.MessageType.ENTER.equals(message.getType())){
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
        messageSendingOperations.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
