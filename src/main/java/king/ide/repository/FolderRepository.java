package king.ide.repository;

import king.ide.domain.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folders, Long> {
    // Spring Data JPA 사용

    // 보류
    // List<Packages> findPackagesByFolderId(Long folderId);

}
