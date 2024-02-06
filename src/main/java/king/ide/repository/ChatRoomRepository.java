package king.ide.repository;

import king.ide.domain.ChatRoom;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChatRoomRepository {
    private Map<String, ChatRoom> store = new HashMap<>();

    //채팅방 생성 후 저장
    public ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setRoomId(UUID.randomUUID().toString());
        chatRoom.setName(name);
        store.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

    //채팅방 조회
    public ChatRoom findById(String id) {
        return store.get(id);
    }

    //모든 채팅방 조회
    public List<ChatRoom> findAll() {
        List<ChatRoom> chatRooms = new ArrayList<>(store.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

}
