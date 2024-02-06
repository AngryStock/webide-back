package king.ide.service;

import king.ide.domain.ChatRoom;
import king.ide.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    //채팅방 생성
    public ChatRoom create(String name) {
        return chatRoomRepository.create(name);
    }

    //모든 채팅방 목록
    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    //채팅방 아이디로 조회
    public ChatRoom findById(String id) {
        return chatRoomRepository.findById(id);
    }
}
