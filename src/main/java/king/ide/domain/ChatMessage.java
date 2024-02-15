package king.ide.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class ChatMessage {

    // 메세지 타입 : 입장, 채팅, 퇴장
    public enum MessageType {
        ENTER, TALK, LEAVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MessageType type;
    private String roomId;
    private String sender; // 유저 닉네임
    private String message;
}
