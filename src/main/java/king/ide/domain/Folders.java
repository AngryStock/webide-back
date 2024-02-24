package king.ide.domain;

import jakarta.persistence.*;
import king.ide.domain.enums.Language;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Folders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private String foldername;
    private Long parentFolderId;
    private LocalDateTime createdAt;
    private boolean droppable = true;

    @Enumerated(EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "folders")
    private List<Packages> packagesList;

    public List<Packages> getPackages() {
        return packagesList;
    }
}
