package king.ide.service;

import jakarta.annotation.PostConstruct;
import king.ide.domain.ChatRoom;
import king.ide.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @PostConstruct
    public void init() {
        if(chatRoomRepository.findByName("default").isEmpty()){
            chatRoomRepository.create("default");
        }
    }

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
        Optional<ChatRoom> chatRoom = chatRoomRepository.findById(id);
        return chatRoom.orElseThrow();
    }
}
