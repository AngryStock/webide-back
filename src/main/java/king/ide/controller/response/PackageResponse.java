package king.ide.controller.response;

import king.ide.domain.Folders;
import king.ide.domain.Packages;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class PackageResponse {

    private Long id;
    private String packagename;

    private Long parent;

    private LocalDateTime createdAt;
    private boolean droppable = true;

    public PackageResponse(Packages pkg) {
        this.id = pkg.getId();
        this.packagename = pkg.getPackagename();

        // 상위 패키지 ID가 있으면 그것을 우선적으로 사용
        if (pkg.getParentPackageId() != null) {
            this.parent = pkg.getParentPackageId();
        } else {
            // 상위 패키지 ID가 없으면 폴더 ID를 사용
            this.parent = pkg.getFolders() != null ? pkg.getFolders().getId() : null;
        }

        this.createdAt = pkg.getCreatedAt();
        this.droppable = pkg.isDroppable();
    }
}
