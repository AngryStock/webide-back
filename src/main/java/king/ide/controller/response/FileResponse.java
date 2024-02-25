package king.ide.controller.response;

import king.ide.domain.Files;
import king.ide.domain.Packages;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class FileResponse {

    private Long id;

    private String filename;
    private String filepath;
    private Long fileSize;
    private String fileType;

    private Long parent;

    //파일에 대한 메타데이터
    private Map<String, String> data = new HashMap<>();

    public FileResponse(Files files) {
        this.id = files.getId();

        this.filename = files.getFilename();
        this.filepath = files.getFilepath();
        this.fileSize = files.getFileSize();
        this.fileType = files.getFileType();

        // parent
        if (files.getPackages() != null) {
            this.parent = files.getPackages().getId(); // 파일이 속한 패키지가 있다면, 그 패키지의 ID를 parent로 설정
        } else if (files.getFolders() != null) {
            this.parent = files.getFolders().getId(); // 파일이 속한 폴더가 있다면, 그 폴더의 ID를 parent로 설정
        }

        // 메타 데이터
        this.data.put("fileType", files.getFileType());
        this.data.put("fileSize", files.getFileSize().toString());
        this.data.put("filepath", files.getFilepath());

        if (files.getCodes() != null && files.getCodes().getContent() != null) {
            this.data.put("content", files.getCodes().getContent());
        }
    }
}
