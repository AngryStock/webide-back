package king.ide.controller.response;

import king.ide.domain.Folders;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class FolderResponse {
    private Long id;
    private String foldername;
    private Long parent;
    private LocalDateTime createdAt;
    private String language;
    private boolean droppable;

    public FolderResponse(Folders folder) {
        this.id = folder.getId();
        this.foldername = folder.getFoldername();
        this.parent = folder.getParentFolderId();
        this.createdAt = folder.getCreatedAt();
        this.language = folder.getLanguage().name(); // Enum 타입을 String으로 변환
        this.droppable = folder.isDroppable();
    }
}
