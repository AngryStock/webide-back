package king.ide.domain;

import lombok.Data;

@Data
public class ChatMessage {
    // 메세지 타입 : 입장, 채팅, 퇴장
    public enum MessageType {
        ENTER, TALK, LEAVE
    }

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
